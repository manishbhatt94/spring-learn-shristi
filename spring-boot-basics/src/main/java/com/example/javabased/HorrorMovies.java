package com.example.javabased;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class HorrorMovies implements IMovie {

	@Override
	public List<String> showMovies() {
		return List.of("Arundhathi", "Annabelle", "Scream");
	}

}
