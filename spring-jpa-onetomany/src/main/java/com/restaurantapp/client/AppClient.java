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
		getById(8);
		getById(35);
		getByCity("Lucknow");
		getByItemTypeCuisine(ItemType.BREAKFAST, Cuisine.SI);
		getByCityAndCuisine("Kolkata", Cuisine.CHINESE);
		getByCategory(Category.VEG, 2);
		getByCategoryItemType(Category.NONVEG, ItemType.LUNCH);
		getByCategoryItemName(Category.VEG, "Masala Dosa");
		getByItemNameContains("fried");
		getByItemNamePriceLessThan("PANEER", 260.00);

	}

	private void addRestaurants() {

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

		addRestaurant(restaurantDto1);

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

		addRestaurant(restaurantDto2);

	}

	private void addRestaurant(RestaurantDto restaurantDto) {

		System.out.println("\n------ addRestaurant --------\n");
		restaurantService.addRestaurant(restaurantDto);
		System.out.println();

	}

	private void getAll() {

		System.out.println("\n------ getAll --------\n");
		restaurantService.getAll().forEach(System.out::println);
		System.out.println();

	}

	private void getById(int restaurantId) {

		System.out.println("\n------ getById --------\n");
		System.out.println("> restaurantId = " + restaurantId);
		System.out.println(restaurantService.getById(restaurantId));
		System.out.println();

	}

	private void getByCity(String city) {

		System.out.println("\n------ getByCity --------\n");
		System.out.println("> city = " + city);
		restaurantService.getByCity(city).forEach(System.out::println);
		System.out.println();

	}

	private void getByItemTypeCuisine(ItemType itemType, Cuisine cuisine) {

		System.out.println("\n------ getByItemTypeCuisine --------\n");
		System.out.println("> itemType = " + itemType.name());
		System.out.println("> cuisine = " + cuisine.getCuisineType());
		restaurantService.getByItemTypeCuisine(itemType.name(), cuisine.getCuisineType()).forEach(System.out::println);
		System.out.println();

	}

	private void getByCityAndCuisine(String city, Cuisine cuisine) {

		System.out.println("\n------ getByCityAndCuisine --------\n");
		System.out.println("> city = " + city);
		System.out.println("> cuisine = " + cuisine.getCuisineType());
		restaurantService.getByCityAndCuisine(city, cuisine.getCuisineType()).forEach(System.out::println);
		System.out.println();

	}

	private void getByCategory(Category category, int limit) {

		System.out.println("\n------ getByCategory --------\n");
		System.out.println("> category = " + category.name());
		System.out.println("> limit = " + limit);
		restaurantService.getByCategory(category).subList(0, limit).forEach(System.out::println);
		System.out.println();

	}

	private void getByCategoryItemType(Category category, ItemType itemType) {

		System.out.println("\n------ getByCategoryItemType --------\n");
		System.out.println("> category = " + category.name());
		System.out.println("> itemType = " + itemType.name());
		restaurantService.getByCategoryItemType(category, itemType.name()).forEach(System.out::println);
		System.out.println();

	}

	private void getByCategoryItemName(Category category, String itemName) {

		System.out.println("\n------ getByCategoryItemName --------\n");
		System.out.println("> category = " + category.name());
		System.out.println("> itemName = " + itemName);
		restaurantService.getByCategoryItemName(category, itemName).forEach(System.out::println);
		System.out.println();

	}

	private void getByItemNameContains(String itemName) {

		System.out.println("\n------ getByItemNameContains --------\n");
		System.out.println("> itemName = " + itemName);
		restaurantService.getByItemNameContains(itemName).forEach(System.out::println);
		System.out.println();

	}

	private void getByItemNamePriceLessThan(String itemName, double price) {

		System.out.println("\n------ getByItemNamePriceLessThan --------\n");
		System.out.println("> itemName = " + itemName);
		System.out.println("> price = " + price);
		restaurantService.getByItemNamePriceLessThan(itemName, price).forEach(System.out::println);
		System.out.println();

	}

}
