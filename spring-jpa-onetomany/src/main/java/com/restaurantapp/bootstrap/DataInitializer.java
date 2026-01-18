package com.restaurantapp.bootstrap;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.restaurantapp.repository.IRestaurantRepository;

@Component
public class DataInitializer {

	private final IRestaurantRepository restaurantRepository;

	@Value("${restaurantapp.bootstrap.seed-initial-data}")
	private boolean shouldSeed;

	public DataInitializer(IRestaurantRepository restaurantRepository) {
		super();
		this.restaurantRepository = restaurantRepository;
	}

	public void initData() {

		if (shouldSeed == false) {
			System.out.println("DataInitializer: Config restaurantapp.bootstrap.seed-initial-data is false.");
			System.out.println("DataInitializer: Skipping initial data seeding.");
			return;
		}

		System.out.println("DataInitializer: Config restaurantapp.bootstrap.seed-initial-data is true.");
		System.out.println("DataInitializer: Attempting to seed initial data.");

		// Save all in one go
		// restaurantRepository.saveAll(restaurants);

		System.out.println("DataInitializer: Initial data seeded.");

	}

}
