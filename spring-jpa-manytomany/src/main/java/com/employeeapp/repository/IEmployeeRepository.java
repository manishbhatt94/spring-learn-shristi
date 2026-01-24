package com.employeeapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employeeapp.model.Employee;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {

}
