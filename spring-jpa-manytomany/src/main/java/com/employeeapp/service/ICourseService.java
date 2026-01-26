package com.employeeapp.service;

import java.util.List;

import com.employeeapp.model.Category;
import com.employeeapp.model.CourseDto;
import com.employeeapp.model.Mode;

public interface ICourseService {

	CourseDto addCourse(CourseDto courseDto);

	void updateCourse(CourseDto courseDto);

	void deleteCourse(int courseId);

	CourseDto getById(int courseId);

	List<CourseDto> getByEmployeeId(int empId);

	// list of online courses
	List<CourseDto> getByMode(Mode mode);

	// list of front-end online courses
	List<CourseDto> getByModeCategory(Mode mode, Category category);

	// list of online courses by a particular department employees
	List<CourseDto> getByDepartmentMode(String department, Mode mode);

}
