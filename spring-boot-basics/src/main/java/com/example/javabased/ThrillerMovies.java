package com.example.javabased;

import java.util.List;

public class ThrillerMovies implements IMovie {

	@Override
	public List<String> showMovies() {
		return List.of("Drishyam", "Piano", "Final Destination");
	}

}
