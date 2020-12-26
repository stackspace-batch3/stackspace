package org.stackspace.employee.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.stackspace.employee.beans.PropertyConfigurationBean;
import org.stackspace.employee.util.PasswordUtility;

@Configuration
public class DBConfig {

	private static final Logger LOGGER = LoggerFactory.getLogger(DBConfig.class);

	@Autowired
	private PasswordUtility pwdUtility;

	@Autowired
	private PropertyConfigurationBean propertyBean;

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = null;

		try {
			LOGGER.info("Start of dataSource()");
			dataSource = new DriverManagerDataSource();
			dataSource.setUrl(propertyBean.getUrl());
			dataSource.setUsername(propertyBean.getUserName());
			dataSource.setPassword(pwdUtility.decript(propertyBean.getPassword()));
		} catch (Exception e) {
			LOGGER.error("Error while creating the DataSource= {}", e);
		}
		LOGGER.info("End of dataSource()");
		return dataSource;
	}

	@Bean(name = "entityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {

		HibernateJpaVendorAdapter jpaVendorAdapter = null;
		LocalContainerEntityManagerFactoryBean factoryBean = null;

		try {
			LOGGER.info("Start of entityManagerFactoryBean()");
			jpaVendorAdapter = new HibernateJpaVendorAdapter();
			factoryBean = new LocalContainerEntityManagerFactoryBean();

			jpaVendorAdapter.setShowSql(propertyBean.isShowSql());
			jpaVendorAdapter.setGenerateDdl(propertyBean.isDdl());
			jpaVendorAdapter.setDatabasePlatform(propertyBean.getPlatform());

			factoryBean.setDataSource(dataSource());
			factoryBean.setPackagesToScan("org.stackspace.employee.entity");
			factoryBean.setJpaVendorAdapter(jpaVendorAdapter);

			LOGGER.info("End of entityManagerFactoryBean()");
		} catch (Exception e) {
			LOGGER.error("Error while preparing the entityManagerFactoryBean ={}", e);
		}
		return factoryBean;

	}

	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {

		JpaTransactionManager jpaTransactionManager = null;
		try {
			jpaTransactionManager = new JpaTransactionManager();
			jpaTransactionManager.setEntityManagerFactory(emf);
		} catch (Exception e) {
			LOGGER.error("Error while creating the platformTransactionManager {}", e);
		}
		return jpaTransactionManager;
	}
}
