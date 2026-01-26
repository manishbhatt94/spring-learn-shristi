package com.employeeapp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.employeeapp.model.CourseLevel;
import com.employeeapp.model.Employee;
import com.employeeapp.model.Mode;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {

	// Eager fetch courses to avoid N+1 problem
	@Query("SELECT DISTINCT e FROM Employee e LEFT JOIN FETCH e.courses")
	List<Employee> findAllWithCourses();

	// For getById - fetch with courses
	@Query("SELECT e FROM Employee e LEFT JOIN FETCH e.courses WHERE e.employeeId = :employeeId")
	Optional<Employee> findByIdWithCourses(@Param("employeeId") int employeeId);

	// For getByCity - fetch with courses
	@Query("SELECT DISTINCT e FROM Employee e LEFT JOIN FETCH e.courses WHERE e.city = :city")
	List<Employee> findByCityWithCourses(@Param("city") String city);

	// For getByCourseName - fetch employees taking a specific course
	@Query("SELECT DISTINCT e FROM Employee e JOIN FETCH e.courses c WHERE c.courseName = :courseName")
	List<Employee> findByCourseName(@Param("courseName") String courseName);

	// For getByCourseNameAndLevel - fetch employees by course name and level
	@Query("SELECT DISTINCT e FROM Employee e JOIN FETCH e.courses c WHERE c.courseName = :courseName AND c.courseLevel = :level")
	List<Employee> findByCourseNameAndLevel(@Param("courseName") String courseName, @Param("level") CourseLevel level);

	// For getByCourseNameAndMode - fetch employees by course name and mode
	@Query("SELECT DISTINCT e FROM Employee e JOIN FETCH e.courses c WHERE c.courseName = :courseName AND c.mode = :mode")
	List<Employee> findByCourseNameAndMode(@Param("courseName") String courseName, @Param("mode") Mode mode);

}
