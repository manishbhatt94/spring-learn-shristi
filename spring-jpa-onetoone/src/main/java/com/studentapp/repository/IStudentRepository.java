package com.studentapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.studentapp.model.Student;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Integer> {

	// SELECT * FROM student s INNER JOIN address a
	// ON s.address_id = a.address_id
	// WHERE a.city = ?
//	@Query("FROM Student s JOIN s.address a WHERE a.city = ?1")
//	List<Student> findByCity(String city);
//
//	@Query("""
//			from Student s join s.address a
//			where s.department = ?1 and a.city = ?2
//			""")
//	List<Student> findByDeptCity(String department, String city);

}
