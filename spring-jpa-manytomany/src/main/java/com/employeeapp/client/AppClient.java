package com.employeeapp.client;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.employeeapp.model.Category;
import com.employeeapp.model.CourseDto;
import com.employeeapp.model.CourseLevel;
import com.employeeapp.model.EmployeeDto;
import com.employeeapp.model.Mode;
import com.employeeapp.service.ICourseService;
import com.employeeapp.service.IEmployeeService;

@Component
public class AppClient {

	@Autowired
	private ICourseService courseService;

	@Autowired
	private IEmployeeService employeeService;

	public void run() {

		// addCoursesAndEmployees();
		getAll();

	}

	private void addCoursesAndEmployees() {

		System.out.println("\n------ addCoursesAndEmployees --------\n");

		// add courses to database
		CourseDto courseDto1 = courseService.addCourse(new CourseDto(null, "Core Java for Beginners", Mode.ONLINE,
				Category.BE.getCategory(), CourseLevel.BEGINNER, "Sripriya Mathan"));
		System.out.println("Added course: " + courseDto1 + "\n");

		CourseDto courseDto2 = courseService.addCourse(new CourseDto(null, "Gen AI - A bird's eye view", Mode.ONLINE,
				Category.ML.getCategory(), CourseLevel.BEGINNER, "Gaurav Sen"));
		System.out.println("Added course: " + courseDto2 + "\n");

		CourseDto courseDto3 = courseService.addCourse(new CourseDto(null, "Architecting React Apps", Mode.OFFLINE,
				Category.FE.getCategory(), CourseLevel.INTERMEDIATE, "Dan Abramov"));
		System.out.println("Added course: " + courseDto3 + "\n");

		// for working with employee

		// create a list
		List<CourseDto> coursesList = Arrays.asList(courseDto1, courseDto2, courseDto3);

		// add to a set
		Set<CourseDto> courses = new HashSet<>(coursesList);
		// create employeeDtos and add course to employee
		EmployeeDto employeeDto = employeeService
				.addEmployee(new EmployeeDto(null, "Rakesh Roshan", "Tech", "Pune", courses));
		System.out.println("Added employee: " + employeeDto + "\n");

		System.out.println("Successfully added 3 more courses & 1 more employee - via Service methods.");
		System.out.println();

	}

	private void getAll() {

		System.out.println("\n------ getAll --------\n");
		employeeService.getAll().forEach(System.out::println);
		System.out.println();

	}

//	private void getById(int restaurantId) {
//
//		System.out.println("\n------ getById --------\n");
//		System.out.println("> restaurantId = " + restaurantId);
//		System.out.println(restaurantService.getById(restaurantId));
//		System.out.println();
//
//	}
//
//	private void getByCity(String city) {
//
//		System.out.println("\n------ getByCity --------\n");
//		System.out.println("> city = " + city);
//		restaurantService.getByCity(city).forEach(System.out::println);
//		System.out.println();
//
//	}
//
//	private void getByItemTypeCuisine(ItemType itemType, Cuisine cuisine) {
//
//		System.out.println("\n------ getByItemTypeCuisine --------\n");
//		System.out.println("> itemType = " + itemType.name());
//		System.out.println("> cuisine = " + cuisine.getCuisineType());
//		restaurantService.getByItemTypeCuisine(itemType.name(), cuisine.getCuisineType()).forEach(System.out::println);
//		System.out.println();
//
//	}

}
