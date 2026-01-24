package com.employeeapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employeeapp.model.Course;

@Repository
public interface ICourseRepository extends JpaRepository<Course, Integer> {

}
