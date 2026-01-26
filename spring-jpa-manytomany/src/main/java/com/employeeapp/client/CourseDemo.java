package com.employeeapp.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.employeeapp.model.Category;
import com.employeeapp.model.CourseDto;
import com.employeeapp.model.CourseLevel;
import com.employeeapp.model.Mode;
import com.employeeapp.service.ICourseService;

@Component
public class CourseDemo {

	@Autowired
	private ICourseService courseService;

	public void run() {

		System.out.println("\n========================================");
		System.out.println("COURSE SERVICE DEMO - Testing All Methods");
		System.out.println("========================================\n");

		// getAll
		getAll();

		// getById
		CourseDto course1 = getById(10); // Java course
		CourseDto course2 = getById(11); // React course
		getById(999); // Invalid ID

		// updateCourse
		if (course1 != null) {
			course1.setInstructor("Rajesh Kumar Sharma");
			course1.setCategory(Category.BE.getCategory());
			course1.setCourseName("RDBMS Tuning For Staff Engineers");
			updateCourse(course1);
		}

		// getByEmployeeId
		getByEmployeeId(5); // Valid employee. Enrolled in course(s).
		getByEmployeeId(18); // Valid employee. Not enrolled in any course.
		getByEmployeeId(999); // Invalid employee.

		// getByMode
		getByMode(Mode.ONLINE);
		getByMode(Mode.OFFLINE);

		// getByModeCategory
		getByModeCategory(Mode.ONLINE, Category.BE);
		getByModeCategory(Mode.HYBRID, Category.FE);
		getByModeCategory(Mode.OFFLINE, Category.PROGRAMMING);

		// getByLevelAndNameContains
		getByLevelAndNameContains("Java", CourseLevel.INTERMEDIATE);
		getByLevelAndNameContains("Cloud", CourseLevel.BEGINNER);
		getByLevelAndNameContains("XYZ", CourseLevel.ADVANCED); // No match

		// getByDepartmentMode
		getByDepartmentMode("Engineering", Mode.ONLINE);
		getByDepartmentMode("Data Science", Mode.ONLINE);
		getByDepartmentMode("DevOps", Mode.HYBRID);

		// getByEmployeeCity
		getByEmployeeCity("Bengaluru");
		getByEmployeeCity("Hyderabad");
		getByEmployeeCity("NonExistentCity");

		// deleteCourse
		// deleteCourse(11);

		System.out.println("\n========================================");
		System.out.println("COURSE SERVICE DEMO - Completed");
		System.out.println("========================================\n");

	}

	private void getAll() {

		System.out.println("\n------ CourseDemo.getAll --------\n");
		courseService.getAll().forEach(System.out::println);
		System.out.println();

	}

	private CourseDto getById(int courseId) {

		System.out.println("\n------ CourseDemo.getById --------\n");
		System.out.println("> courseId = " + courseId);
		CourseDto courseDto = courseService.getById(courseId);
		System.out.println(courseDto);
		System.out.println();
		return courseDto;

	}

	private void updateCourse(CourseDto courseDto) {

		System.out.println("\n------ CourseDemo.updateCourse --------\n");
		System.out.println("> Updating course: " + courseDto.getCourseName());
		courseService.updateCourse(courseDto);
		System.out.println("Course updated successfully.");
		System.out.println();

	}

	private void getByEmployeeId(int empId) {

		System.out.println("\n------ CourseDemo.getByEmployeeId --------\n");
		System.out.println("> empId = " + empId);
		List<CourseDto> courses = courseService.getByEmployeeId(empId);
		if (courses.isEmpty()) {
			System.out.println("No courses found for employee ID: " + empId);
		} else {
			System.out.println("Found " + courses.size() + " course(s):");
			courses.forEach(c -> System.out.println("  - " + c.getCourseName() + " (" + c.getMode() + ")"));
		}
		System.out.println();

	}

	private void getByMode(Mode mode) {

		System.out.println("\n------ CourseDemo.getByMode --------\n");
		System.out.println("> mode = " + mode);
		List<CourseDto> courses = courseService.getByMode(mode);
		System.out.println("Found " + courses.size() + " course(s) in " + mode + " mode:");
		courses.forEach(c -> System.out.println("  - " + c.getCourseName() + " by " + c.getInstructor()));
		System.out.println();

	}

	private void getByModeCategory(Mode mode, Category category) {

		System.out.println("\n------ CourseDemo.getByModeCategory --------\n");
		System.out.println("> mode = " + mode + ", category = " + category);
		List<CourseDto> courses = courseService.getByModeCategory(mode, category);
		if (courses.isEmpty()) {
			System.out.println("No courses found for mode '" + mode + "' and category '" + category + "'");
		} else {
			System.out.println("Found " + courses.size() + " course(s):");
			courses.forEach(
					c -> System.out.println("  - " + c.getCourseName() + " (Level: " + c.getCourseLevel() + ")"));
		}
		System.out.println();

	}

	private void getByLevelAndNameContains(String namePartial, CourseLevel level) {

		System.out.println("\n------ CourseDemo.getByLevelAndNameContains --------\n");
		System.out.println("> namePartial = '" + namePartial + "', level = " + level);
		List<CourseDto> courses = courseService.getByLevelAndNameContains(namePartial, level);
		if (courses.isEmpty()) {
			System.out.println("No courses found matching '" + namePartial + "' at level " + level);
		} else {
			System.out.println("Found " + courses.size() + " course(s):");
			courses.forEach(c -> System.out.println("  - " + c.getCourseName() + " (" + c.getMode() + ")"));
		}
		System.out.println();

	}

	private void getByDepartmentMode(String department, Mode mode) {

		System.out.println("\n------ CourseDemo.getByDepartmentMode --------\n");
		System.out.println("> department = '" + department + "', mode = " + mode);
		List<CourseDto> courses = courseService.getByDepartmentMode(department, mode);
		if (courses.isEmpty()) {
			System.out.println("No " + mode + " courses found for department: " + department);
		} else {
			System.out.println("Found " + courses.size() + " " + mode + " course(s) taken by " + department + ":");
			courses.forEach(c -> System.out.println("  - " + c.getCourseName() + " (" + c.getCategory() + ")"));
		}
		System.out.println();

	}

	private void getByEmployeeCity(String city) {

		System.out.println("\n------ CourseDemo.getByEmployeeCity --------\n");
		System.out.println("> city = " + city);
		List<CourseDto> courses = courseService.getByEmployeeCity(city);
		if (courses.isEmpty()) {
			System.out.println("No courses found for employees in city: " + city);
		} else {
			System.out.println("Found " + courses.size() + " course(s) taken by employees in " + city + ":");
			courses.forEach(c -> System.out.println("  - " + c.getCourseName() + " [" + c.getCourseLevel() + "]"));
		}
		System.out.println();

	}

	private void deleteCourse(int courseId) {

		System.out.println("\n------ CourseDemo.deleteCourse --------\n");
		System.out.println("> courseId = " + courseId);
		courseService.deleteCourse(courseId);
		System.out.println("Deleted course successfully.");
		System.out.println();

	}

}
