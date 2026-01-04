package com.example.javabased;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Theatre {

	@Autowired
	@Qualifier("animationMovies")
	private IMovie movie;

	public List<String> runningMovies() {
		return movie.showMovies();
	}

}
