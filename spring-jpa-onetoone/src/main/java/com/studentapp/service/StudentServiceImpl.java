package com.studentapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.studentapp.exception.StudentNotFoundException;
import com.studentapp.model.Student;
import com.studentapp.model.StudentDto;
import com.studentapp.repository.IStudentRepository;
import com.studentapp.util.StudentMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class StudentServiceImpl implements IStudentService {

	private final IStudentRepository repository;
	private final StudentMapper mapper;

	@Override
	public void addStudent(StudentDto studentDto) {
		Student student = mapper.convertToEntity(studentDto);
		repository.save(student);
	}

	@Override
	public void updateStudent(StudentDto studentDto) {
		Student student = mapper.convertToEntity(studentDto);
		repository.save(student);
	}

	@Override
	public void deleteStudent(int studentId) {
		repository.deleteById(studentId);
	}

	@Override
	public List<StudentDto> getAll() {
		return repository.findAll().stream().map(mapper::convertToDto).toList();
	}

	@Override
	public StudentDto getById(int studentId) throws StudentNotFoundException {
		return repository.findById(studentId).map(mapper::convertToDto).orElseThrow(
				() -> new StudentNotFoundException(String.format("Student with ID: %d not found.", studentId)));
	}

	@Override
	public List<StudentDto> getByDepartment(String department) {
		return repository.findByDepartment(department).stream().map(mapper::convertToDto).toList();
	}

	@Override
	public List<StudentDto> getByCity(String city) {
		// return
		// repository.findByAddressCity(city).stream().map(mapper::convertToDto).toList();
		return repository.findByCity(city).stream().map(mapper::convertToDto).toList();
	}

	@Override
	public List<StudentDto> getByDeptAndCity(String department, String city) {
		return repository.findByDeptCity(department, city).stream().map(mapper::convertToDto).toList();
	}

}
