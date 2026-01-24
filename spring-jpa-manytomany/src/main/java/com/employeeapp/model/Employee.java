package com.employeeapp.model;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Employee {

	@Id
	@GeneratedValue(generator = "empl_gen", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "empl_gen", sequenceName = "empl_seq", initialValue = 1, allocationSize = 1)
	private Integer employeeId;

	private String employeeName;

	@Column(length = 40)
	private String department;

	@Column(length = 100)
	private String city;

	@ManyToMany
	// create a junction table for adding both keys
	@JoinTable(name = "employee_courses", joinColumns = @JoinColumn(name = "employee_id"), inverseJoinColumns = @JoinColumn(name = "course_id"))
	private Set<Course> courses;

}
