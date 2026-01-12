package com.studentapp.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.studentapp.service.IStudentService;

@Component
public class AppClient {

	@Autowired
	private IStudentService studentService;

	public void run() {

		System.out.println("------ getAll --------");
		studentService.getAll().forEach(System.out::println);
		System.out.println();

		System.out.println("------ getByDepartment --------");
		studentService.getByDepartment("Civil").forEach(System.out::println);
		System.out.println();

		System.out.println("------ getByCity --------");
		studentService.getByCity("Kolkata").forEach(System.out::println);
		System.out.println();

		System.out.println("------ getByDeptCity --------");
		studentService.getByDeptAndCity("ECE", "Noida").forEach(System.out::println);
		System.out.println();

		System.out.println("------ getById (valid) --------");
		System.out.println(studentService.getById(508));
		System.out.println();

		System.out.println("------ getById (invalid) --------");
		System.out.println(studentService.getById(208));
		System.out.println();

	}

}
