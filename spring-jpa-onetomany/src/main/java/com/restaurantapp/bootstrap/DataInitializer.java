package com.restaurantapp.bootstrap;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.restaurantapp.model.Category;
import com.restaurantapp.model.Cuisine;
import com.restaurantapp.model.ItemType;
import com.restaurantapp.model.MenuItem;
import com.restaurantapp.model.Restaurant;
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

		populateRestaurantsAndMenuItems();

		System.out.println("DataInitializer: Initial data seeded.");

	}

	public void populateRestaurantsAndMenuItems() {

		List<Restaurant> restaurants = new ArrayList<>();

		// Restaurant 1: South Indian Vegetarian

		Set<MenuItem> menuItems1 = new HashSet<>(List.of(
		// @formatter:off
			new MenuItem(null, "Masala Dosa", 45.00, ItemType.BREAKFAST.name()),
			new MenuItem(null, "Idli Vada", 40.00, ItemType.BREAKFAST.name()),
			new MenuItem(null, "Filter Coffee", 55.00, ItemType.BREAKFAST.name())
		// @formatter:on
		));
		Restaurant restaurant1 = new Restaurant(null, "Vidyarthi Bhavan", "Bangalore", Cuisine.SI.getCuisineType(),
				Category.VEG, menuItems1);

		restaurants.add(restaurant1);

		// Restaurant 2: North Indian Non-Veg

		Set<MenuItem> menuItems2 = new HashSet<>(List.of(
		// @formatter:off
			new MenuItem(null, "Butter Chicken", 320.00, ItemType.DINNER.name()),
			new MenuItem(null, "Tandoori Chicken", 280.00, ItemType.STARTER.name()),
			new MenuItem(null, "Dal Makhani", 150.00, ItemType.LUNCH.name()),
			new MenuItem(null, "Gulab Jamun", 180.00, ItemType.DESSERT.name())
		// @formatter:on
		));
		Restaurant restaurant2 = new Restaurant(null, "Punjab Grill", "Chandigarh", Cuisine.NI.getCuisineType(),
				Category.NONVEG, menuItems2);

		restaurants.add(restaurant2);

		// Restaurant 3: Chinese Non-Veg

		Set<MenuItem> menuItems3 = new HashSet<>(List.of(
		// @formatter:off
			new MenuItem(null, "Chicken Manchurian", 240.00, ItemType.STARTER.name()),
			new MenuItem(null, "Hot and Sour Soup", 180.00, ItemType.SOUP.name()),
			new MenuItem(null, "Hakka Noodles with Prawns", 280.00, ItemType.DINNER.name())
		// @formatter:on
		));
		Restaurant restaurant3 = new Restaurant(null, "Mainland China", "Bangalore", Cuisine.CHINESE.getCuisineType(),
				Category.NONVEG, menuItems3);

		restaurants.add(restaurant3);

		// Restaurant 4: Italian Vegetarian

		Set<MenuItem> menuItems4 = new HashSet<>(List.of(
		// @formatter:off
			new MenuItem(null, "Margherita Pizza", 380.00, ItemType.LUNCH.name()),
			new MenuItem(null, "Penne Arrabbiata", 420.00, ItemType.DINNER.name()),
			new MenuItem(null, "Tiramisu", 220.00, ItemType.DESSERT.name()),
			new MenuItem(null, "Bruschetta", 180.00, ItemType.STARTER.name())
		// @formatter:on
		));
		Restaurant restaurant4 = new Restaurant(null, "Toscano", "Mumbai", Cuisine.ITALIAN.getCuisineType(),
				Category.VEG, menuItems4);

		restaurants.add(restaurant4);

		// Restaurant 5: Mexican Vegetarian

		Set<MenuItem> menuItems5 = new HashSet<>(List.of(
		// @formatter:off
			new MenuItem(null, "Veggie Burrito Bowl", 320.00, ItemType.LUNCH.name()),
			new MenuItem(null, "Cheese Quesadilla", 280.00, ItemType.DINNER.name()),
			new MenuItem(null, "Nachos Supreme", 200.00, ItemType.STARTER.name())
		// @formatter:on
		));
		Restaurant restaurant5 = new Restaurant(null, "Chimichangas", "Kolkata", Cuisine.MEXICAN.getCuisineType(),
				Category.VEG, menuItems5);

		restaurants.add(restaurant5);

		// Restaurant 6: South Indian Non-Veg

		Set<MenuItem> menuItems6 = new HashSet<>(List.of(
		// @formatter:off
			new MenuItem(null, "Fish Fry", 340.00, ItemType.STARTER.name()),
			new MenuItem(null, "Chicken Chettinad", 280.00, ItemType.DINNER.name()),
			new MenuItem(null, "Rasam", 120.00, ItemType.SOUP.name()),
			new MenuItem(null, "Payasam", 150.00, ItemType.DESSERT.name())
		// @formatter:on
		));
		Restaurant restaurant6 = new Restaurant(null, "Coastal Curry", "Kochi", Cuisine.SI.getCuisineType(),
				Category.NONVEG, menuItems6);

		restaurants.add(restaurant6);

		// Restaurant 7: North Indian Vegetarian

		Set<MenuItem> menuItems7 = new HashSet<>(List.of(
		// @formatter:off
			new MenuItem(null, "Paneer Tikka", 250.00, ItemType.STARTER.name()),
			new MenuItem(null, "Shahi Paneer", 280.00, ItemType.LUNCH.name()),
			new MenuItem(null, "Aloo Paratha", 200.00, ItemType.BREAKFAST.name())
		// @formatter:on
		));
		Restaurant restaurant7 = new Restaurant(null, "Sagar Ratna", "New Delhi", Cuisine.NI.getCuisineType(),
				Category.VEG, menuItems7);

		restaurants.add(restaurant7);

		// Restaurant 8: Chinese Vegetarian

		Set<MenuItem> menuItems8 = new HashSet<>(List.of(
		// @formatter:off
			new MenuItem(null, "Veg Manchow Soup", 220.00, ItemType.SOUP.name()),
			new MenuItem(null, "Chilli Paneer", 260.00, ItemType.STARTER.name()),
			new MenuItem(null, "Veg Fried Rice", 240.00, ItemType.DINNER.name()),
			new MenuItem(null, "Honey Chilli Potato", 180.00, ItemType.STARTER.name())
		// @formatter:on
		));
		Restaurant restaurant8 = new Restaurant(null, "Golden Dragon", "Bangalore", Cuisine.CHINESE.getCuisineType(),
				Category.VEG, menuItems8);

		restaurants.add(restaurant8);

		// Save all in one go
		restaurantRepository.saveAll(restaurants);

	}

}
