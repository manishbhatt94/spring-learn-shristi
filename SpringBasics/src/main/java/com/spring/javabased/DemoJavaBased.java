package com.spring.javabased;

import java.util.stream.Stream;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DemoJavaBased {

	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext("com.spring.javabased");

		// Print the beans created by the IOC Container
		Stream.of(context.getBeanDefinitionNames()).forEach(System.out::println);
		// Above line prints:
		// appConfig, getBackend, frontend, institute
		System.out.println();

		Institute institute = context.getBean("institute", Institute.class);
		institute.courseDetails();

	}

}
