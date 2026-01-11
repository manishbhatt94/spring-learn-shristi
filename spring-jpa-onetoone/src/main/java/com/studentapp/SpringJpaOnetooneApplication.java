package com.studentapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.studentapp.bootstrap.DataInitializer;

@SpringBootApplication
public class SpringJpaOnetooneApplication implements CommandLineRunner {

	@Autowired
	private DataInitializer dataInitializer;

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaOnetooneApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		dataInitializer.initData();

	}

}
