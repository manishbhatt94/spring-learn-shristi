package com.example.autowiring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Player {

	// auto-wiring by type
	@Autowired
	@Qualifier("outdoor")
	private ISports sports; // = new Outdoor

	@Autowired
	private ISports indoor; // = new Indoor

	public void playGames(String type) {
		System.out.println("Choose game in club");
		if (type.equals("out")) {
			sports.gamesAvailable().forEach(System.out::println);
		} else {
			indoor.gamesAvailable().forEach(System.out::println);
		}
	}

}
