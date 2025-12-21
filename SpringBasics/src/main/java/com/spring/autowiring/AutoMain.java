package com.spring.autowiring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutoMain {

	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext("com.spring.autowiring");

		Rectangle rect = context.getBean(Rectangle.class);
		rect.calcArea(10, 20);

		Parallelogram parallelogram = context.getBean(Parallelogram.class);
		parallelogram.calcArea(10, 20);

		IShape shape = context.getBean(Triangle.class);
		shape.calcArea(10, 20);

	}

}
