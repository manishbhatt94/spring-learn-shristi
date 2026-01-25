package com.employeeapp.model;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(exclude = "employees")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class CourseDto {

	@EqualsAndHashCode.Include
	private Integer courseId;

	private String courseName;

	private Mode mode;

	private String category; // take values from enum web, frontend

	private CourseLevel courseLevel;

	private String instructor;

	private Set<EmployeeDto> employees;

}
