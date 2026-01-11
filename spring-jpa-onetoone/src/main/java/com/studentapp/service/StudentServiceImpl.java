package com.studentapp.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.studentapp.model.StudentDto;
import com.studentapp.repository.IStudentRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class StudentServiceImpl implements IStudentService {

	private final IStudentRepository repository;
	private final ModelMapper mapper;

	@Override
	public void addStudent(StudentDto studentDto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateStudent(StudentDto studentDto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteStudent(int studentId) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<StudentDto> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StudentDto getById(int studentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StudentDto> getByDepartment(String department) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StudentDto> getByCity(String city) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StudentDto> getByDeptAndCity(String department, String city) {
		// TODO Auto-generated method stub
		return null;
	}

}
