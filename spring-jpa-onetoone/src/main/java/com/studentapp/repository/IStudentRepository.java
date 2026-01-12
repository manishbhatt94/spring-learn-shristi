package com.studentapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.studentapp.model.Student;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Integer> {

	// Derived Queries:

	List<Student> findByDepartment(String department);

	List<Student> findByAddressCity(String city);

	// Custom Queries:

	// SELECT * FROM student s INNER JOIN address a
	// ON s.address_id = a.address_id
	// WHERE a.city = ?
	@Query("SELECT s FROM Student s LEFT JOIN s.address a WHERE a.city = ?1 ORDER BY s.rollNumber DESC")
	List<Student> findByCity(String city);

	@Query("""
			select s from Student s left join s.address a
			where s.department = ?1 and a.city = ?2
			""")
	List<Student> findByDeptCity(String department, String city);

}
