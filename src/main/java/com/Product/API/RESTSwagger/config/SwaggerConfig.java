package com.Product.API.RESTSwagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SwaggerConfig {
	
	@Bean
	public OpenAPI customAPI() {
		return new OpenAPI().info(new Info().title("swagger example API").version("1.0.0")
				.license(new License().name("Licensa Software").url("www.google.com.br")));
				
				
				
	}

   
}