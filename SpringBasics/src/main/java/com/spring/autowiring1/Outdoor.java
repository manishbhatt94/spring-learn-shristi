package com.spring.autowiring1;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Outdoor implements ISports {

	@Override
	public List<String> gamesAvailable() {
		return List.of("Football", "Cricket");
	}

}
