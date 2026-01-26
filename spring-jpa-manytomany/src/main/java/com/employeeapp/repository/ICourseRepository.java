package com.employeeapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.employeeapp.model.Course;
import com.employeeapp.model.CourseLevel;
import com.employeeapp.model.Mode;

@Repository
public interface ICourseRepository extends JpaRepository<Course, Integer> {

	// For getByEmployeeId - fetch courses taken by a specific employee
	@Query("SELECT DISTINCT c FROM Course c JOIN c.employees e WHERE e.employeeId = :empId")
	List<Course> findByEmployeeId(@Param("empId") int empId);

	// For getByMode - fetch courses by mode
	@Query("SELECT c FROM Course c WHERE c.mode = :mode")
	List<Course> findByMode(@Param("mode") Mode mode);

	// For getByModeCategory - fetch courses by mode and category
	@Query("SELECT c FROM Course c WHERE c.mode = :mode AND c.category = :category")
	List<Course> findByModeAndCategory(@Param("mode") Mode mode, @Param("category") String category);

	// For getByLevelAndNameContains - fetch courses by level and partial name match
	@Query("SELECT c FROM Course c WHERE c.courseLevel = :level AND c.courseName LIKE %:namePartial%")
	List<Course> findByCourseLevelAndCourseNameContaining(@Param("level") CourseLevel level,
			@Param("namePartial") String namePartial);

	// For getByDepartmentMode - fetch courses taken by employees from a department
	// with specific mode
	@Query("SELECT DISTINCT c FROM Course c JOIN c.employees e WHERE e.department = :department AND c.mode = :mode")
	List<Course> findByEmployeeDepartmentAndMode(@Param("department") String department, @Param("mode") Mode mode);

	// For getByEmployeeCity - fetch courses taken by employees from a specific city
	@Query("SELECT DISTINCT c FROM Course c JOIN c.employees e WHERE e.city = :city")
	List<Course> findByEmployeeCity(@Param("city") String city);

}
