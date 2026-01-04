package com.example.javabased;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class AnimationMovies implements IMovie {

	@Override
	public List<String> showMovies() {
		return List.of("How To Train Your Dragon", "Cars", "Boss Baby");
	}

}
