package com.greetapp.service;

import java.util.List;

public interface IMovieService {

	List<String> getAllMovies();

	List<String> getByLanguage(String language);

}
