package com.employeeapp.service;

import java.util.List;

import com.employeeapp.model.CourseLevel;
import com.employeeapp.model.EmployeeDto;
import com.employeeapp.model.Mode;

public interface IEmployeeService {

	void addEmployee(EmployeeDto employeeDto);

	void updateEmployee(EmployeeDto employeeDto);

	void deleteEmployee(int employeeId);

	EmployeeDto getById(int employeeId);

	List<EmployeeDto> getAll();

	List<EmployeeDto> getByCity(String city);

	// list of employees taking java
	List<EmployeeDto> getByCourseName(String courseName);

	// list of employees taking java beginner level
	List<EmployeeDto> getByCourseNameAndLevel(String courseName, CourseLevel level);

	// list of employees taking java online
	List<EmployeeDto> getByCourseNameAndMode(String courseName, Mode mode);

}
