package com.restaurantapp.client;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.restaurantapp.model.Category;
import com.restaurantapp.model.Cuisine;
import com.restaurantapp.model.ItemType;
import com.restaurantapp.model.MenuItemDto;
import com.restaurantapp.model.RestaurantDto;
import com.restaurantapp.service.IRestaurantService;

@Component
public class AppClient {

	@Autowired
	private IRestaurantService restaurantService;

	public void run() {

		// addRestaurants();

		getAll();

	}

	public void addRestaurants() {

		System.out.println("------ addRestaurant --------");
		// Restaurant 1: North Indian Non-Veg (Lucknow)
		Set<MenuItemDto> menuItemsDto1 = new HashSet<>(List.of(
		// @formatter:off
			new MenuItemDto(null, "Seekh Kebab", 180.00, ItemType.STARTER.name()),
			new MenuItemDto(null, "Chicken Biryani", 220.00, ItemType.DINNER.name()),
			new MenuItemDto(null, "Mutton Korma", 160.00, ItemType.LUNCH.name()),
			new MenuItemDto(null, "Roomali Roti", 80.00, ItemType.DINNER.name())
		// @formatter:on
		));
		RestaurantDto restaurantDto1 = new RestaurantDto(null, "Nawabi Kitchen", "Lucknow", Cuisine.NI.getCuisineType(),
				Category.NONVEG, menuItemsDto1);
		restaurantService.addRestaurant(restaurantDto1);
		System.out.println();

		System.out.println("------ addRestaurant --------");
		// Restaurant 2: South Indian Vegetarian (Chennai)
		Set<MenuItemDto> menuItemsDto2 = new HashSet<>(List.of(
		// @formatter:off
			new MenuItemDto(null, "Mini Tiffin", 50.00, ItemType.BREAKFAST.name()),
			new MenuItemDto(null, "Meals", 120.00, ItemType.LUNCH.name()),
			new MenuItemDto(null, "Rava Dosa", 45.00, ItemType.BREAKFAST.name())
		// @formatter:on
		));
		RestaurantDto restaurantDto2 = new RestaurantDto(null, "Saravana Bhavan", "Chennai",
				Cuisine.SI.getCuisineType(), Category.VEG, menuItemsDto2);
		restaurantService.addRestaurant(restaurantDto2);
		System.out.println();

	}

	public void getAll() {

		System.out.println("------ getAll --------");
		restaurantService.getAll().forEach(System.out::println);
		System.out.println();

	}

}
