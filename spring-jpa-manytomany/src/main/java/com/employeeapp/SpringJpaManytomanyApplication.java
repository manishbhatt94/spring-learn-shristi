package com.employeeapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.employeeapp.bootstrap.DataInitializer;
import com.employeeapp.client.AppClient;

@SpringBootApplication
public class SpringJpaManytomanyApplication implements CommandLineRunner {

	@Autowired
	private DataInitializer dataInitializer;

	@Autowired
	private AppClient appClient;

	public static void main(String[] args) {

		SpringApplication.run(SpringJpaManytomanyApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {

		dataInitializer.initData();
		appClient.run();

	}

}
