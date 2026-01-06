package com.bookapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bookapp.main.Client;

@SpringBootApplication
public class SpringbootBookappBasicApplication implements CommandLineRunner {

	@Autowired
	private Client client;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootBookappBasicApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		client.runApp();
	}

}
