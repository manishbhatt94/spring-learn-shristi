package com.spring.setter;

import java.util.stream.Stream;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class EmpMain {

	public static void main(String[] args) {

		// ApplicationContext loads the Beans eagerly.
		// While BeanFactory loads the Beans lazily.

		// Create the IOC Container
		ApplicationContext context = new AnnotationConfigApplicationContext("com.spring.setter");

		String[] beanDefNames = context.getBeanDefinitionNames();
		Stream.of(beanDefNames).forEach(System.out::println);
		System.out.println();

		// Get the object from the IOC Container
		Employee employee = (Employee) context.getBean("employee");
		System.out.println(employee);

		// Get an instance of Address
		Address address = context.getBean("address", Address.class);
		System.out.println(address);

	}

}
