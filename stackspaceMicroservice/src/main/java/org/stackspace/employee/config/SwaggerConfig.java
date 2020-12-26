package org.stackspace.employee.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

	@Bean
	public Docket docket() {
		return new Docket(DocumentationType.SWAGGER_2).select().paths(PathSelectors.any())
				.apis(RequestHandlerSelectors.basePackage("org.stackspace.employee")).build().apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().license("1.0").licenseUrl("http://www.stackspace.com")
				.description("Stackspace Documentation")
				.contact(new Contact("Sri", "http://www.stackspace.com", "sri.java1995@gmail.com")).build();
	}

}
