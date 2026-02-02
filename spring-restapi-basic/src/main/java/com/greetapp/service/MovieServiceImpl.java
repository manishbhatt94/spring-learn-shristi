package com.greetapp.service;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class MovieServiceImpl implements IMovieService {

	@Override
	public List<String> getAllMovies() {
		return List.of("Tangled", "RRR", "Premalu", "24");
	}

	@Override
	public List<String> getByLanguage(String language) {
		if (language.equals("tamil")) {
			return List.of("Asuran", "Dude");
		} else if (language.equals("malayalam")) {
			return List.of("Home", "Premam");
		} else {
			return Collections.emptyList();
		}
	}

}
