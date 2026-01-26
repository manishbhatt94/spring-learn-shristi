package com.employeeapp.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.employeeapp.config.EmployeeMapper;
import com.employeeapp.model.CourseLevel;
import com.employeeapp.model.Employee;
import com.employeeapp.model.EmployeeDto;
import com.employeeapp.model.Mode;
import com.employeeapp.repository.IEmployeeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements IEmployeeService {

	private final IEmployeeRepository employeeRepository;
	private final EmployeeMapper mapper;

	/**
	 * Add a new employee
	 *
	 * @Transactional needed for write operation with potential rollback
	 */
	@Override
	@Transactional
	public EmployeeDto addEmployee(EmployeeDto employeeDto) {
		Employee employee = mapper.convertToEmployeeEntity(employeeDto);
		Employee saved = employeeRepository.save(employee);
		return mapper.convertToEmployeeDto(saved);
	}

	/**
	 * Update existing employee
	 *
	 * @Transactional needed for write operation with potential rollback
	 */
	@Override
	@Transactional
	public void updateEmployee(EmployeeDto employeeDto) {
		Employee employee = mapper.convertToEmployeeEntity(employeeDto);
		employeeRepository.save(employee);
	}

	/**
	 * Delete employee by ID
	 *
	 * @Transactional needed for write operation with potential rollback
	 */
	@Override
	@Transactional
	public void deleteEmployee(int employeeId) {
		employeeRepository.deleteById(employeeId);
	}

	/**
	 * Get employee by ID with courses
	 *
	 * @Transactional(readOnly = true) for consistent read
	 */
	@Override
	@Transactional(readOnly = true)
	public EmployeeDto getById(int employeeId) {
		return employeeRepository.findByIdWithCourses(employeeId).map(mapper::convertToEmployeeDto).orElse(null);
	}

	/**
	 * Get all employees with courses
	 *
	 * @Transactional(readOnly = true) for consistent read
	 */
	@Override
	@Transactional(readOnly = true)
	public List<EmployeeDto> getAll() {
		return mapper.convertToEmployeeDto(employeeRepository.findAllWithCourses());
	}

	/**
	 * Get employees by city with courses
	 *
	 * @Transactional(readOnly = true) for consistent read
	 */
	@Override
	@Transactional(readOnly = true)
	public List<EmployeeDto> getByCity(String city) {
		return mapper.convertToEmployeeDto(employeeRepository.findByCityWithCourses(city));
	}

	/**
	 * Get employees taking a specific course
	 *
	 * @Transactional(readOnly = true) for consistent read
	 */
	@Override
	@Transactional(readOnly = true)
	public List<EmployeeDto> getByCourseName(String courseName) {
		return mapper.convertToEmployeeDto(employeeRepository.findByCourseName(courseName));
	}

	/**
	 * Get employees taking a specific course at a specific level
	 *
	 * @Transactional(readOnly = true) for consistent read
	 */
	@Override
	@Transactional(readOnly = true)
	public List<EmployeeDto> getByCourseNameAndLevel(String courseName, CourseLevel level) {
		return mapper.convertToEmployeeDto(employeeRepository.findByCourseNameAndLevel(courseName, level));
	}

	/**
	 * Get employees taking a specific course in a specific mode
	 *
	 * @Transactional(readOnly = true) for consistent read
	 */
	@Override
	@Transactional(readOnly = true)
	public List<EmployeeDto> getByCourseNameAndMode(String courseName, Mode mode) {
		return mapper.convertToEmployeeDto(employeeRepository.findByCourseNameAndMode(courseName, mode));
	}

}
