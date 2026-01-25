package com.employeeapp.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(exclude = "employees")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Course {

	@Id
	@GeneratedValue(generator = "course_gen", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "course_gen", sequenceName = "course_seq", initialValue = 10, allocationSize = 1)
	@EqualsAndHashCode.Include
	private Integer courseId;

	@Column(length = 120)
	private String courseName;

	@Enumerated(EnumType.STRING)
	private Mode mode;

	@Column(length = 60)
	private String category; // take values from enum web, frontend

	@Enumerated(EnumType.STRING)
	private CourseLevel courseLevel;

	private String instructor;

	@ManyToMany(mappedBy = "courses")
	private Set<Employee> employees = new HashSet<>();

}
