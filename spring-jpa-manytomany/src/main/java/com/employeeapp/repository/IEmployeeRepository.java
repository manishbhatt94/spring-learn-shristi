package com.employeeapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.employeeapp.model.Employee;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {

	@Query("SELECT DISTINCT e FROM Employee e LEFT JOIN FETCH e.courses")
	List<Employee> findAllWithCourses();

	List<Employee> findByCity(String city);

}
