package com.employeeapp.config;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.employeeapp.model.Course;
import com.employeeapp.model.CourseDto;
import com.employeeapp.model.Employee;
import com.employeeapp.model.EmployeeDto;

@Component
public class EmployeeMapper {

	@Autowired
	private ModelMapper mapper;

	public EmployeeDto deepConvertToEmployeeDto(Employee employee) {
		Set<CourseDto> courseDtos = employee.getCourses().stream().map(this::convertToCourseDto)
				.collect(Collectors.toSet());
		EmployeeDto employeeDto = convertToEmployeeDto(employee);
		employeeDto.setCourses(courseDtos);
		return employeeDto;
	}

	public List<EmployeeDto> deepConvertToEmployeeDto(List<Employee> employees) {
		return employees.stream().map(this::deepConvertToEmployeeDto).toList();
	}

	public EmployeeDto convertToEmployeeDto(Employee employee) {
		return mapper.map(employee, EmployeeDto.class);
	}

	public List<EmployeeDto> convertToEmployeeDto(List<Employee> employees) {
		return employees.stream().map(this::convertToEmployeeDto).toList();
	}

	public Employee convertToEmployeeEntity(EmployeeDto employeeDto) {
		return mapper.map(employeeDto, Employee.class);
	}

	public CourseDto convertToCourseDto(Course course) {
		return mapper.map(course, CourseDto.class);
	}

	public Course convertToCourseEntity(CourseDto courseDto) {
		return mapper.map(courseDto, Course.class);
	}

}
