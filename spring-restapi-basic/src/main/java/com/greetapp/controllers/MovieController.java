package com.greetapp.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.greetapp.service.IMovieService;

@RestController
public class MovieController {

	// auto-wire service
	private IMovieService movieService;

	public MovieController(IMovieService movieService) {
		super();
		this.movieService = movieService;
	}

	// http://localhost:8080/movies
	@GetMapping("/movies")
	List<String> getAllMovies() {
		// call the method of service
		return movieService.getAllMovies();
	}

	// http://localhost:8080/movies/language/tamil
	@GetMapping("/movies/language/{language}")
	List<String> getByLanguage(@PathVariable String language) {
		return movieService.getByLanguage(language);
	}

}
