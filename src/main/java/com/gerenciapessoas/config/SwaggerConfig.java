package com.gerenciapessoas.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.gerenciapessoas.controller"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(getApiInfo());
	}
	
	private ApiInfo getApiInfo() {
		return new ApiInfo("Swagger2 API Documentation Gerenciar Pessoas", 
				"Generate Documentation for REST API",
				"1.0","urn:tos",
				new Contact("Danilo Vieira Rocha", "https://blog-dvr-f0b29.web.app/home", "danilorocha722@gmail.com"),
				"Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0",Collections.emptyList());
	}

}
