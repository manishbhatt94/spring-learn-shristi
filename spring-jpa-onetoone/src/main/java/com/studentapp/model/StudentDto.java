package com.studentapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class StudentDto {

	private Integer studentId;

	private String rollNumber;

	private String name;

	private String programme; // BTech, MTech, MSc, BSc

	private String department; // CSE, ECE, EE, ME, Civil

	private Address address;

}
