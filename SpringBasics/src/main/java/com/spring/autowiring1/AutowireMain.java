package com.spring.autowiring1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutowireMain {

	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext("com.spring.autowiring1");
		Player player = context.getBean("player", Player.class);
		player.playGames("in");
		player.playGames("out");

	}

}
