package com.employeeapp.service;

import java.util.List;

import com.employeeapp.model.Category;
import com.employeeapp.model.CourseDto;
import com.employeeapp.model.CourseLevel;
import com.employeeapp.model.Mode;

public interface ICourseService {

	CourseDto addCourse(CourseDto courseDto);

	void updateCourse(CourseDto courseDto);

	void deleteCourse(int courseId);

	CourseDto getById(int courseId);

	List<CourseDto> getAll();

	List<CourseDto> getByEmployeeId(int empId);

	// list of online (mode) courses
	List<CourseDto> getByMode(Mode mode);

	// list of front-end (category) online (mode) courses
	List<CourseDto> getByModeCategory(Mode mode, Category category);

	// list of courses of particular difficulty (level), and courseName matching
	List<CourseDto> getByLevelAndNameContains(String courseNamePartial, CourseLevel level);

	// list of online (mode) courses taken by a particular department employees
	List<CourseDto> getByDepartmentMode(String department, Mode mode);

	// list of courses taken by employees based in a particular city
	List<CourseDto> getByEmployeeCity(String city);

}
