package com.example.certi.veri.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WebConfig implements WebMvcConfigurer{

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**") //Allowing all the end-points
		.allowedOrigins("")
		.allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") //Allowing the methods
		.allowedHeaders("*") //Allowing the headers
		.allowCredentials(true); //Allow credentials (cookies, authorization headers, etc.)
		
		//WebMvcConfigurer.super.addCorsMappings(registry);
	}

	
}
