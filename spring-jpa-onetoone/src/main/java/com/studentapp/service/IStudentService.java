package com.studentapp.service;

import java.util.List;

import com.studentapp.exception.StudentNotFoundException;
import com.studentapp.model.StudentDto;

public interface IStudentService {

	void addStudent(StudentDto studentDto);

	void updateStudent(StudentDto studentDto);

	void deleteStudent(int studentId);

	List<StudentDto> getAll();

	StudentDto getById(int studentId) throws StudentNotFoundException;

	List<StudentDto> getByDepartment(String department);

	List<StudentDto> getByCity(String city);

	List<StudentDto> getByDeptAndCity(String department, String city);

}
