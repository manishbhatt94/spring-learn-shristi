package com.spring.javabased;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AppConfig {

	// Inside @Configuration annotated class - Here we add Bean Definitions.

	// Bean Definition - is a method to create a Spring bean.
	// Has to be annotated with @Bean annotation.

	// What is going to be the bean name?
	// -> The bean name - will be same as the method name.

	// Bean name is going to be "getBackend"
	@Bean
	Backend getBackend() {
		return new Backend();
	}

	// Bean name is going to be "frontend"
	@Primary
	@Bean
	Frontend frontend() {
		return new Frontend();
	}

	// Bean name is going to be "institute"
	@Bean
	Institute institute() {
		return new Institute();
	}

}
