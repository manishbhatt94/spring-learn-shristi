package com.spring.constr;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
public class Student {

	private String name;
	private int studId;
	private Department department;

	public Student(Department department) {
		super();
		this.department = department;
	}

	public String getName() {
		return name;
	}

	@Value("${student.name}")
	public void setName(String name) {
		this.name = name;
	}

	public int getStudId() {
		return studId;
	}

	@Value("${student.id}")
	public void setStudId(int studId) {
		this.studId = studId;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", studId=" + studId + ", department=" + department + "]";
	}

}
