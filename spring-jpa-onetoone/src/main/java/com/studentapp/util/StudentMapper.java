package com.studentapp.util;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.studentapp.model.Student;
import com.studentapp.model.StudentDto;

@Component
public class StudentMapper {

	@Autowired
	ModelMapper mapper;

	public Student convertToEntity(StudentDto studentDto) {
		return mapper.map(studentDto, Student.class);
	}

	public StudentDto convertToDto(Student student) {
		return mapper.map(student, StudentDto.class);
	}

}
