package com.restaurantapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.restaurantapp.bootstrap.DataInitializer;
import com.restaurantapp.client.AppClient;

@SpringBootApplication
public class SpringJpaOnetomanyApplication implements CommandLineRunner {

	@Autowired
	private DataInitializer dataInitializer;

	@Autowired
	private AppClient appClient;

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaOnetomanyApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		dataInitializer.initData();
		appClient.run();

	}

}
