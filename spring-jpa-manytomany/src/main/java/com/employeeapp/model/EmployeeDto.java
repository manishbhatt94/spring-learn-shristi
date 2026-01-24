package com.employeeapp.model;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmployeeDto {

	private Integer employeeId;

	private String employeeName;

	private String department;

	private String city;

	private Set<CourseDto> courses;

}
