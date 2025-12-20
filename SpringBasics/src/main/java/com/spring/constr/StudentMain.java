package com.spring.constr;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class StudentMain {

	public static void main(String[] args) {

		// Create the IOC Container
		ApplicationContext context = new AnnotationConfigApplicationContext("com.spring.constr");

		Student student = context.getBean(Student.class);
		System.out.println(student);

	}

}
