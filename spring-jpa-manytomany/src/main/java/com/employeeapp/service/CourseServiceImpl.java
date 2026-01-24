package com.employeeapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.employeeapp.config.EmployeeMapper;
import com.employeeapp.model.Course;
import com.employeeapp.model.CourseDto;
import com.employeeapp.repository.ICourseRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements ICourseService {

	private final ICourseRepository courseRepository;
	private final EmployeeMapper mapper;

	@Override
	public CourseDto addCourse(CourseDto courseDto) {
		Course course = mapper.convertToCourseEntity(courseDto);
		Course savedCourse = courseRepository.save(course);
		return mapper.convertToCourseDto(savedCourse);
	}

	@Override
	public void updateCourse(CourseDto courseDto) {
		Course course = mapper.convertToCourseEntity(courseDto);
		courseRepository.save(course);
	}

	@Override
	public void deleteCourse(int courseId) {
		courseRepository.deleteById(courseId);
	}

	@Override
	public CourseDto getById(int courseId) {
		return courseRepository.findById(courseId).map(mapper::convertToCourseDto).orElse(null);
	}

	@Override
	public List<CourseDto> getByEmployeeId(int empId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CourseDto> getByMode(String mode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CourseDto> getByModeCategory(String mode, String category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CourseDto> getByDepartmentMode(String department, String mode) {
		// TODO Auto-generated method stub
		return null;
	}

}
