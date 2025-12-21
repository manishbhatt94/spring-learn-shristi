package com.spring.autowiring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutoMain {

	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext("com.spring.autowiring");

		ShapeFactory factory = (ShapeFactory) context.getBean("shapeFactory");
		// ShapeFactory factory = context.getBean("shapeFactory", ShapeFactory.class);
		factory.printArea(10, 20);

	}

}
