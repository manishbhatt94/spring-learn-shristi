package com.studentapp.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Student {

	@Id
	@GeneratedValue(generator = "student_seq_gen", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "student_seq_gen", sequenceName = "stud_seq", initialValue = 501, allocationSize = 1)
	private Integer studentId;

	@Column(length = 20, unique = true)
	private String rollNumber;

	@Column(length = 120)
	private String name;

	@Column(length = 20)
	private String programme; // BTech, MTech, MSc, BSc

	@Column(length = 50)
	private String department; // CSE, ECE, EE, ME, Civil

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id")
	private Address address;

}
