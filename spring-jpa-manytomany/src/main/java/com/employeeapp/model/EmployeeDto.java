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
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class EmployeeDto {

	@EqualsAndHashCode.Include
	private Integer employeeId;

	private String employeeName;

	private String department;

	private String city;

	private Set<CourseDto> courses;

}
