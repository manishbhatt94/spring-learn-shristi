package com.employeeapp.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.employeeapp.config.EmployeeMapper;
import com.employeeapp.model.Category;
import com.employeeapp.model.Course;
import com.employeeapp.model.CourseDto;
import com.employeeapp.model.CourseLevel;
import com.employeeapp.model.Mode;
import com.employeeapp.repository.ICourseRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements ICourseService {

	private final ICourseRepository courseRepository;
	private final EmployeeMapper mapper;

	/**
	 * Add a new course
	 *
	 * @Transactional needed for write operation with potential rollback
	 */
	@Override
	@Transactional
	public CourseDto addCourse(CourseDto courseDto) {
		Course course = mapper.convertToCourseEntity(courseDto);
		Course savedCourse = courseRepository.save(course);
		return mapper.convertToCourseDto(savedCourse);
	}

	/**
	 * Update existing course
	 *
	 * @Transactional needed for write operation with potential rollback
	 */
	@Override
	@Transactional
	public void updateCourse(CourseDto courseDto) {
		Course course = mapper.convertToCourseEntity(courseDto);
		courseRepository.save(course);
	}

	/**
	 * Delete course by ID
	 *
	 * @Transactional needed for write operation with potential rollback
	 */
	@Override
	@Transactional
	public void deleteCourse(int courseId) {
		courseRepository.deleteById(courseId);
	}

	/**
	 * Get course by ID
	 *
	 * @Transactional(readOnly = true) for consistent read
	 */
	@Override
	@Transactional(readOnly = true)
	public CourseDto getById(int courseId) {
		return courseRepository.findById(courseId).map(mapper::convertToCourseDto).orElse(null);
	}

	/**
	 * Get all courses
	 *
	 * @Transactional(readOnly = true) for consistent read
	 */
	@Override
	@Transactional(readOnly = true)
	public List<CourseDto> getAll() {
		return mapper.convertToCourseDto(courseRepository.findAll());
	}

	/**
	 * Get all courses taken by a specific employee
	 *
	 * @Transactional(readOnly = true) for consistent read
	 */
	@Override
	@Transactional(readOnly = true)
	public List<CourseDto> getByEmployeeId(int empId) {
		return mapper.convertToCourseDto(courseRepository.findByEmployeeId(empId));
	}

	/**
	 * Get courses by mode (ONLINE, HYBRID, OFFLINE)
	 *
	 * @Transactional(readOnly = true) for consistent read
	 */
	@Override
	@Transactional(readOnly = true)
	public List<CourseDto> getByMode(Mode mode) {
		return mapper.convertToCourseDto(courseRepository.findByMode(mode));
	}

	/**
	 * Get courses by mode and category
	 *
	 * @Transactional(readOnly = true) for consistent read
	 */
	@Override
	@Transactional(readOnly = true)
	public List<CourseDto> getByModeCategory(Mode mode, Category category) {
		return mapper.convertToCourseDto(courseRepository.findByModeAndCategory(mode, category.getCategory()));
	}

	/**
	 * Get courses by level and partial name match
	 *
	 * @Transactional(readOnly = true) for consistent read
	 */
	@Override
	@Transactional(readOnly = true)
	public List<CourseDto> getByLevelAndNameContains(String courseNamePartial, CourseLevel level) {
		return mapper.convertToCourseDto(
				courseRepository.findByCourseLevelAndCourseNameContaining(level, courseNamePartial));
	}

	/**
	 * Get courses by department and mode Find courses taken by employees from a
	 * specific department with a specific mode
	 *
	 * @Transactional(readOnly = true) for consistent read
	 */
	@Override
	@Transactional(readOnly = true)
	public List<CourseDto> getByDepartmentMode(String department, Mode mode) {
		return mapper.convertToCourseDto(courseRepository.findByEmployeeDepartmentAndMode(department, mode));
	}

	/**
	 * Get courses by employee city Find courses taken by employees from a specific
	 * city
	 *
	 * @Transactional(readOnly = true) for consistent read
	 */
	@Override
	@Transactional(readOnly = true)
	public List<CourseDto> getByEmployeeCity(String city) {
		return mapper.convertToCourseDto(courseRepository.findByEmployeeCity(city));
	}
}
