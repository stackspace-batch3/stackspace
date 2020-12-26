package org.stackspace.employee.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PropertyConfigurationBean2 {

	@Value("${stackspace.datasource.url}")
	private String url;

	@Value("${stackspace.datasource.username}")
	private String userName;

	@Value("${stackspace.datasource.password}")
	private String pwd;

	@Value("${stackspace.datasource.platform}")
	private String platform;

	@Value("${stackspace.datasource.ddl}")
	private boolean ddl;

	@Value("${stackspace.datasource.showSql}")
	private boolean showSql;

	@Value("${stackspace.datasource.ddluto}")
	private String ddluto;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public boolean isDdl() {
		return ddl;
	}

	public void setDdl(boolean ddl) {
		this.ddl = ddl;
	}

	public boolean isShowSql() {
		return showSql;
	}

	public void setShowSql(boolean showSql) {
		this.showSql = showSql;
	}

	public String getDdluto() {
		return ddluto;
	}

	public void setDdluto(String ddluto) {
		this.ddluto = ddluto;
	}

}
