package com.restaurantapp.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.restaurantapp.service.IRestaurantService;

@Component
public class AppClient {

	@Autowired
	private IRestaurantService restaurantService;

	public void run() {

		System.out.println("------ getAll --------");

		System.out.println();

	}

}
