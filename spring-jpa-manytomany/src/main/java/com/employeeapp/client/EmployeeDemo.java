package com.employeeapp.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.employeeapp.model.CourseDto;
import com.employeeapp.model.CourseLevel;
import com.employeeapp.model.EmployeeDto;
import com.employeeapp.model.Mode;
import com.employeeapp.service.ICourseService;
import com.employeeapp.service.IEmployeeService;

@Component
public class EmployeeDemo {

	@Autowired
	private IEmployeeService employeeService;

	@Autowired
	private ICourseService courseService;

	public void run() {

		System.out.println("\n========================================");
		System.out.println("EMPLOYEE SERVICE DEMO - Testing All Methods");
		System.out.println("========================================\n");

		// getAll
		getAll();

		// getById
		EmployeeDto emp1Dto = getById(1); // valid employeeId
		EmployeeDto emp3Dto = getById(3); // valid employeeId
		EmployeeDto emp6Dto = getById(6); // valid employeeId
		getById(404); // invalid employeeId

		// updateEmployee - update name, department
		emp1Dto.setEmployeeName("Arjun Kulkarni");
		emp1Dto.setDepartment("Tech");
		updateEmployee(emp1Dto);

		// updateEmployee - remove all enrolled courses
		emp6Dto.getCourses().clear();
		updateEmployee(emp6Dto);

		// updateEmployee - remove one enrolled courses, add 2 others
		CourseDto emp3Course1 = emp3Dto.getCourses().stream().findFirst().orElse(null);
		if (emp3Course1 != null) {
			emp3Dto.getCourses().remove(emp3Course1);
		}
		emp3Dto.getCourses().add(courseService.getById(14));
		emp3Dto.getCourses().add(courseService.getById(15));
		updateEmployee(emp3Dto);

		// deleteEmployee
		deleteEmployee(4);

		// getByCity
		getByCity("Mumbai");
		getByCity("Seoul"); // Not existent city

		// getByCourseName
		getByCourseName("Full Stack Java Development with Spring Boot");
		getByCourseName("Advanced React and TypeScript");
		getByCourseName("Machine Learning Fundamentals");
		getByCourseName("NonExistentCourse");

		// getByCourseNameAndLevel
		getByCourseNameAndLevel("Full Stack Java Development with Spring Boot", CourseLevel.INTERMEDIATE);
		getByCourseNameAndLevel("Advanced React and TypeScript", CourseLevel.ADVANCED);
		getByCourseNameAndLevel("AWS Cloud Practitioner Essentials", CourseLevel.BEGINNER);
		getByCourseNameAndLevel("Machine Learning Fundamentals", CourseLevel.ADVANCED); // No match

		// getByCourseNameAndMode
		getByCourseNameAndMode("Full Stack Java Development with Spring Boot", Mode.ONLINE);
		getByCourseNameAndMode("Advanced React and TypeScript", Mode.HYBRID);
		getByCourseNameAndMode("Data Structures and Algorithms in Python", Mode.OFFLINE);
		getByCourseNameAndMode("Full Stack Java Development with Spring Boot", Mode.OFFLINE); // No match

		System.out.println("\n========================================");
		System.out.println("EMPLOYEE SERVICE DEMO - Completed");
		System.out.println("========================================\n");

	}

	private void getAll() {

		System.out.println("\n------ EmployeeDemo.getAll --------\n");
		employeeService.getAll().forEach(System.out::println);
		System.out.println();

	}

	private EmployeeDto getById(int employeeId) {

		System.out.println("\n------ EmployeeDemo.getById --------\n");
		System.out.println("> employeeId = " + employeeId);
		EmployeeDto employeeDto = employeeService.getById(employeeId);
		System.out.println(employeeDto);
		System.out.println();
		return employeeDto;

	}

	private void updateEmployee(EmployeeDto employeeDto) {

		System.out.println("\n------ EmployeeDemo.updateEmployee --------\n");
		System.out.println("> Updating employee to = " + employeeDto);
		employeeService.updateEmployee(employeeDto);
		System.out.println("Updated employee.");
		System.out.println();

	}

	private void deleteEmployee(int employeeId) {

		System.out.println("\n------ EmployeeDemo.deleteEmployee --------\n");
		System.out.println("> employeeId = " + employeeId);
		employeeService.deleteEmployee(employeeId);
		System.out.println("Deleted employee.");
		System.out.println();

	}

	private void getByCity(String city) {

		System.out.println("\n------ EmployeeDemo.getByCity --------\n");
		System.out.println("> city = " + city);
		List<EmployeeDto> employees = employeeService.getByCity(city);
		if (employees.isEmpty()) {
			System.out.println("No employees found in city: " + city);
		} else {
			employees.forEach(System.out::println);
		}
		System.out.println();

	}

	private void getByCourseName(String courseName) {

		System.out.println("\n------ EmployeeDemo.getByCourseName --------\n");
		System.out.println("> courseName = " + courseName);
		List<EmployeeDto> employees = employeeService.getByCourseName(courseName);
		if (employees.isEmpty()) {
			System.out.println("No employees found taking course: " + courseName);
		} else {
			System.out.println("Found " + employees.size() + " employee(s) taking this course:");
			employees.forEach(
					emp -> System.out.println("  - " + emp.getEmployeeName() + " (" + emp.getDepartment() + ")"));
		}
		System.out.println();

	}

	private void getByCourseNameAndLevel(String courseName, CourseLevel level) {

		System.out.println("\n------ EmployeeDemo.getByCourseNameAndLevel --------\n");
		System.out.println("> courseName = " + courseName);
		System.out.println("> level = " + level);
		List<EmployeeDto> employees = employeeService.getByCourseNameAndLevel(courseName, level);
		if (employees.isEmpty()) {
			System.out.println("No employees found taking course '" + courseName + "' at level " + level);
		} else {
			System.out.println("Found " + employees.size() + " employee(s):");
			employees.forEach(emp -> System.out.println("  - " + emp.getEmployeeName() + " from " + emp.getCity()));
		}
		System.out.println();

	}

	private void getByCourseNameAndMode(String courseName, Mode mode) {

		System.out.println("\n------ EmployeeDemo.getByCourseNameAndMode --------\n");
		System.out.println("> courseName = " + courseName);
		System.out.println("> mode = " + mode);
		List<EmployeeDto> employees = employeeService.getByCourseNameAndMode(courseName, mode);
		if (employees.isEmpty()) {
			System.out.println("No employees found taking course '" + courseName + "' in mode " + mode);
		} else {
			System.out.println("Found " + employees.size() + " employee(s):");
			employees.forEach(emp -> System.out
					.println("  - " + emp.getEmployeeName() + " (" + emp.getDepartment() + ", " + emp.getCity() + ")"));
		}
		System.out.println();

	}

}
