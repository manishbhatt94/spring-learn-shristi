package com.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.example.javabased.AnimationMovies;
import com.example.javabased.HorrorMovies;
import com.example.javabased.Theatre;
import com.example.javabased.ThrillerMovies;

@Configuration
public class AppConfig {

	@Bean
	HorrorMovies horror() {
		return new HorrorMovies();
	}

	@Bean
	@Primary
	ThrillerMovies thriller() {
		return new ThrillerMovies();
	}

	@Bean
	AnimationMovies animation() {
		return new AnimationMovies();
	}

	@Bean
	Theatre theatre() {
		return new Theatre();
	}

}
