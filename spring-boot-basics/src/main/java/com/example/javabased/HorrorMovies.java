package com.example.javabased;

import java.util.List;

public class HorrorMovies implements IMovie {

	@Override
	public List<String> showMovies() {
		return List.of("Arundhathi", "Annabelle", "Scream");
	}

}
