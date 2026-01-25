package com.employeeapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

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

	@Override
	public EmployeeDto addEmployee(EmployeeDto employeeDto) {
		Employee employee = mapper.convertToEmployeeEntity(employeeDto);
		Employee savedEmployee = employeeRepository.save(employee);
		return mapper.convertToEmployeeDto(savedEmployee);
	}

	@Override
	public void updateEmployee(EmployeeDto employeeDto) {
		Employee employee = mapper.convertToEmployeeEntity(employeeDto);
		employeeRepository.save(employee);
	}

	@Override
	public void deleteEmployee(int employeeId) {
		employeeRepository.deleteById(employeeId);
	}

	@Override
	public EmployeeDto getById(int employeeId) {
		return employeeRepository.findById(employeeId).map(mapper::deepConvertToEmployeeDto).orElse(null);
	}

	@Override
	public List<EmployeeDto> getAll() {
		List<Employee> employees = employeeRepository.findAllWithCourses();
		return mapper.convertToEmployeeDto(employees);
	}

	@Override
	public List<EmployeeDto> getByCity(String city) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmployeeDto> getByCourseName(String courseName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmployeeDto> getByCourseNameAndLevel(String courseName, CourseLevel level) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmployeeDto> getByCourseNameAndMode(String courseName, Mode mode) {
		// TODO Auto-generated method stub
		return null;
	}

}
