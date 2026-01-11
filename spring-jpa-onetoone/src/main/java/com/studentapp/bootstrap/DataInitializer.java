package com.studentapp.bootstrap;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.studentapp.model.Address;
import com.studentapp.model.Student;
import com.studentapp.repository.IStudentRepository;

@Component
public class DataInitializer {

	private final IStudentRepository studentRepository;

	public DataInitializer(IStudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}

	public void initData() {

		List<Student> students = new ArrayList<>();

		// 1
		Address addr1 = new Address(null, "12A", "MG Road", "Indiranagar", "Bengaluru", "Karnataka", 560001);
		Student s1 = new Student(null, "CSE001", "Amit Sharma", "BTech", "CSE", addr1);
		students.add(s1);

		// 2
		Address addr2 = new Address(null, "45B", "Marine Drive", "Churchgate", "Mumbai", "Maharashtra", 400002);
		Student s2 = new Student(null, "ECE002", "Priya Nair", "BTech", "ECE", addr2);
		students.add(s2);

		// 3
		Address addr3 = new Address(null, "101", "Main Street", "Sector 15", "Chandigarh", "Chandigarh", 160015);
		Student s3 = new Student(null, "ME003", "Ravi Kumar", "BTech", "ME", addr3);
		students.add(s3);

		// 4
		Address addr4 = new Address(null, "22", "FC Road", "Shivaji Nagar", "Pune", "Maharashtra", 411004);
		Student s4 = new Student(null, "CSE004", "Sneha Patil", "BTech", "CSE", addr4);
		students.add(s4);

		// 5
		Address addr5 = new Address(null, "7", "Road No 12", "Banjara Hills", "Hyderabad", "Telangana", 500034);
		Student s5 = new Student(null, "CE005", "Arjun Reddy", "BTech", "Civil", addr5);
		students.add(s5);

		// 6
		Address addr6 = new Address(null, "89", "2nd Avenue", "Anna Nagar West", "Chennai", "Tamil Nadu", 600040);
		Student s6 = new Student(null, "EE006", "Meera Iyer", "BTech", "EE", addr6);
		students.add(s6);

		// 7
		Address addr7 = new Address(null, "56", "Ring Road", "Salt Lake Sector V", "Kolkata", "West Bengal", 700091);
		Student s7 = new Student(null, "CSE007", "Karan Singh", "MTech", "CSE", addr7);
		students.add(s7);

		// 8
		Address addr8 = new Address(null, "33", "Main Bazaar", "Ashok Nagar", "Delhi", "Delhi", 110018);
		Student s8 = new Student(null, "ME008", "Neha Gupta", "MTech", "ME", addr8);
		students.add(s8);

		// 9
		Address addr9 = new Address(null, "14", "Station Road", "Civil Lines", "Jaipur", "Rajasthan", 302006);
		Student s9 = new Student(null, "ECE009", "Rahul Verma", "MTech", "ECE", addr9);
		students.add(s9);

		// 10
		Address addr10 = new Address(null, "77", "Relief Road", "Law Garden", "Ahmedabad", "Gujarat", 380006);
		Student s10 = new Student(null, "CSE010", "Divya Joshi", "MSc", "CSE", addr10);
		students.add(s10);

		// 11
		Address addr11 = new Address(null, "9", "Bailey Road", "Patliputra Colony", "Patna", "Bihar", 800013);
		Student s11 = new Student(null, "EE011", "Siddharth Rao", "MSc", "EE", addr11);
		students.add(s11);

		// 12
		Address addr12 = new Address(null, "5", "NH16", "Khandagiri", "Bhubaneswar", "Odisha", 751030);
		Student s12 = new Student(null, "CE012", "Ananya Das", "BSc", "Civil", addr12);
		students.add(s12);

		// 13
		Address addr13 = new Address(null, "66", "Rashbehari Ave", "Gariahat", "Kolkata", "West Bengal", 700019);
		Student s13 = new Student(null, "CSE013", "Vikram Mehta", "BSc", "CSE", addr13);
		students.add(s13);

		// 14
		Address addr14 = new Address(null, "18", "Electronic City", "Sector 62", "Noida", "Uttar Pradesh", 201301);
		Student s14 = new Student(null, "ECE014", "Shalini Menon", "MSc", "ECE", addr14);
		students.add(s14);

		// 15
		Address addr15 = new Address(null, "27", "Grand Trunk Road", "Model Town", "Ludhiana", "Punjab", 141002);
		Student s15 = new Student(null, "ME015", "Harish Choudhary", "BSc", "ME", addr15);
		students.add(s15);

		// 16
		Address addr16 = new Address(null, "88", "MG Road", "Panampilly Nagar", "Kochi", "Kerala", 682036);
		Student s16 = new Student(null, "CSE016", "Pooja Pillai", "MTech", "CSE", addr16);
		students.add(s16);

		// Save all in one go
		studentRepository.saveAll(students);

	}

}
