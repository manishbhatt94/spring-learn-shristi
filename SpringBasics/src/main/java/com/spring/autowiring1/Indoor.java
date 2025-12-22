package com.spring.autowiring1;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Indoor implements ISports {

	@Override
	public List<String> gamesAvailable() {
		return List.of("Chess", "Carrom");
	}

}
