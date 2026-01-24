package com.employeeapp.bootstrap;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.employeeapp.model.Course;
import com.employeeapp.model.CourseLevel;
import com.employeeapp.model.Employee;
import com.employeeapp.model.Mode;
import com.employeeapp.repository.ICourseRepository;
import com.employeeapp.repository.IEmployeeRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DataInitializer {

	private final IEmployeeRepository employeeRepository;
	private final ICourseRepository courseRepository;

	@Value("${employeeapp.bootstrap.seed-initial-data}")
	private boolean shouldSeed;

	public void initData() {

		if (shouldSeed == false) {
			System.out.println("DataInitializer: Config employeeapp.bootstrap.seed-initial-data is false.");
			System.out.println("DataInitializer: Skipping initial data seeding.");
			return;
		}

		System.out.println("DataInitializer: Config employeeapp.bootstrap.seed-initial-data is true.");
		System.out.println("DataInitializer: Attempting to seed initial data.");

		populateEmployeeAppSeedData();

		System.out.println("DataInitializer: Initial data seeded.");

	}

	private void populateEmployeeAppSeedData() {

		// Create 10 course entities, and save them all.
		List<Course> courses = new ArrayList<>();

		courses.add(new Course(null, "Full Stack Java Development with Spring Boot", Mode.ONLINE, "Backend",
				CourseLevel.INTERMEDIATE, "Rajesh Kumar", new HashSet<>()));
		courses.add(new Course(null, "Advanced React and TypeScript", Mode.HYBRID, "Frontend", CourseLevel.ADVANCED,
				"Priya Sharma", new HashSet<>()));
		courses.add(new Course(null, "Microservices Architecture with Spring Cloud", Mode.ONLINE, "Backend",
				CourseLevel.ADVANCED, "Amit Patel", new HashSet<>()));
		courses.add(new Course(null, "AWS Cloud Practitioner Essentials", Mode.ONLINE, "Cloud", CourseLevel.BEGINNER,
				"Sneha Reddy", new HashSet<>()));
		courses.add(new Course(null, "Data Structures and Algorithms in Python", Mode.OFFLINE, "Programming",
				CourseLevel.INTERMEDIATE, "Vikram Singh", new HashSet<>()));
		courses.add(new Course(null, "DevOps with Docker and Kubernetes", Mode.ONLINE, "DevOps", CourseLevel.ADVANCED,
				"Anita Desai", new HashSet<>()));
		courses.add(new Course(null, "Angular for Enterprise Applications", Mode.HYBRID, "Frontend",
				CourseLevel.INTERMEDIATE, "Karthik Iyer", new HashSet<>()));
		courses.add(new Course(null, "Machine Learning Fundamentals", Mode.ONLINE, "AI/ML", CourseLevel.BEGINNER,
				"Deepak Verma", new HashSet<>()));
		courses.add(new Course(null, "RESTful API Design and Development", Mode.ONLINE, "Backend",
				CourseLevel.INTERMEDIATE, "Lakshmi Nair", new HashSet<>()));
		courses.add(new Course(null, "Agile and Scrum for Software Teams", Mode.OFFLINE, "Management",
				CourseLevel.BEGINNER, "Ravi Menon", new HashSet<>()));

		courseRepository.saveAll(courses);
		System.out.println("DataInitializer: Saved 10 courses.");

		// Create 20 employee entities.
		List<Employee> employees = new ArrayList<>();

		employees.add(new Employee(null, "Arjun Mehta", "Engineering", "Bengaluru", new HashSet<>()));
		employees.add(new Employee(null, "Divya Krishnan", "Engineering", "Hyderabad", new HashSet<>()));
		employees.add(new Employee(null, "Rohan Joshi", "Product Management", "Pune", new HashSet<>()));
		employees.add(new Employee(null, "Meera Gupta", "Engineering", "Mumbai", new HashSet<>()));
		employees.add(new Employee(null, "Aditya Rao", "Data Science", "Bengaluru", new HashSet<>()));
		employees.add(new Employee(null, "Kavya Nambiar", "Engineering", "Chennai", new HashSet<>()));
		employees.add(new Employee(null, "Siddharth Bansal", "Engineering", "Noida", new HashSet<>()));
		employees.add(new Employee(null, "Pooja Agarwal", "Quality Assurance", "Gurgaon", new HashSet<>()));
		employees.add(new Employee(null, "Nikhil Chopra", "Engineering", "Bengaluru", new HashSet<>()));
		employees.add(new Employee(null, "Anjali Malhotra", "DevOps", "Hyderabad", new HashSet<>()));
		employees.add(new Employee(null, "Varun Shetty", "Engineering", "Mumbai", new HashSet<>()));
		employees.add(new Employee(null, "Shreya Pillai", "Data Science", "Pune", new HashSet<>()));
		employees.add(new Employee(null, "Kunal Saxena", "Engineering", "Bengaluru", new HashSet<>()));
		employees.add(new Employee(null, "Neha Kapoor", "Product Management", "Delhi", new HashSet<>()));
		employees.add(new Employee(null, "Rahul Bhatt", "Engineering", "Chennai", new HashSet<>()));
		employees.add(new Employee(null, "Ishita Sengupta", "Engineering", "Kolkata", new HashSet<>()));
		employees.add(new Employee(null, "Abhishek Tiwari", "Engineering", "Bengaluru", new HashSet<>()));
		employees.add(new Employee(null, "Simran Kaur", "Quality Assurance", "Chandigarh", new HashSet<>()));
		employees.add(new Employee(null, "Gaurav Pandey", "Engineering", "Noida", new HashSet<>()));
		employees.add(new Employee(null, "Riya Das", "DevOps", "Hyderabad", new HashSet<>()));

		// For 16 of them, set their courses to 1-4 courses.
		Random random = new Random();
		for (int i = 0; i < 16; i++) {
			Employee employee = employees.get(i);
			int numberOfCourses = random.nextInt(4) + 1; // 1 to 4 courses

			Set<Course> assignedCourses = new HashSet<>();
			while (assignedCourses.size() < numberOfCourses) {
				Course randomCourse = courses.get(random.nextInt(courses.size()));
				assignedCourses.add(randomCourse);
			}

			employee.setCourses(assignedCourses);
		}

		// Then save all employees.
		employeeRepository.saveAll(employees);
		System.out.println("DataInitializer: Saved 20 employees (16 with courses, 4 without courses).");
	}

}
