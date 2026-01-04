package com.example;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.autowiring.Player;
import com.example.javabased.Theatre;
import com.spring.concept.Address;
import com.spring.concept.Employee;

@SpringBootApplication(scanBasePackages = { "com.spring", "com.example" })
public class SpringBootBasicsApplication implements CommandLineRunner {

	@Autowired
	private ApplicationContext context;

	@Autowired
	private Employee hrExecutive;

	@Autowired
	private Player player;

	@Autowired
	private Theatre theatre;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootBasicsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// printBeans();
		demoTheatre();

	}

	public void printBeans() {
		String[] beanDefNames = context.getBeanDefinitionNames();
		Stream.of(beanDefNames).forEach(System.out::println);
		System.out.println();
	}

	public void demoEmployee() {
		// Get the object from the IOC Container
		Employee employee = (Employee) context.getBean("employee");
		System.out.println(employee);

		// Get an instance of Address
		Address address = context.getBean("address", Address.class);
		System.out.println(address);

		System.out.println(hrExecutive);
	}

	public void demoPlayer() {
		player.playGames("in");
		player.playGames("out");
	}

	public void demoTheatre() {
		theatre.runningMovies().forEach(System.out::println);
	}

}
