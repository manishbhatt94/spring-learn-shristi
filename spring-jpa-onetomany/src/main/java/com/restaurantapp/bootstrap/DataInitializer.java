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

		// Restaurant 1: South Indian Vegetarian (Bangalore)

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

		// Restaurant 2: North Indian Non-Veg (Chandigarh)

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

		// Restaurant 3: Chinese Non-Veg (Bangalore)

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

		// Restaurant 4: Italian Vegetarian (Mumbai)

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

		// Restaurant 5: Mexican Vegetarian (Kolkata)

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

		// Restaurant 6: South Indian Non-Veg (Kochi)

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

		// Restaurant 7: North Indian Vegetarian (New Delhi)

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

		// Restaurant 8: Chinese Vegetarian (Bangalore)

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

		// Restaurant 9: Tunday Kababi (Lucknow)
		Set<MenuItem> menuItems9 = new HashSet<>(List.of(
		// @formatter:off
			new MenuItem(null, "Mutton Galawati Kabab", 240.00, ItemType.STARTER.name()),
			new MenuItem(null, "Mughlai Paratha", 60.00, ItemType.DINNER.name())
		// @formatter:on
		));
		Restaurant restaurant9 = new Restaurant(null, "Tunday Kababi", "Lucknow", Cuisine.NI.getCuisineType(),
				Category.NONVEG, menuItems9);
		restaurants.add(restaurant9);

		// Restaurant 10: Royal Cafe (Lucknow)
		Set<MenuItem> menuItems10 = new HashSet<>(List.of(
		// @formatter:off
			new MenuItem(null, "Iconic Basket Chaat", 280.00, ItemType.SNACKS.name()),
			new MenuItem(null, "Paneer Butter Masala", 350.00, ItemType.DINNER.name())
		// @formatter:on
		));
		Restaurant restaurant10 = new Restaurant(null, "Royal Cafe", "Lucknow", Cuisine.FASTFOOD.getCuisineType(),
				Category.VEG, menuItems10);
		restaurants.add(restaurant10);

		// Restaurant 11: Peter Cat (Kolkata)
		Set<MenuItem> menuItems11 = new HashSet<>(List.of(
		// @formatter:off
			new MenuItem(null, "Chelo Kebab", 645.00, ItemType.DINNER.name()),
			new MenuItem(null, "Chicken Hakka Noodles", 420.00, ItemType.DINNER.name())
		// @formatter:on
		));
		Restaurant restaurant11 = new Restaurant(null, "Peter Cat", "Kolkata", Cuisine.NI.getCuisineType(),
				Category.NONVEG, menuItems11);
		restaurants.add(restaurant11);

		// Restaurant 12: Mocambo (Kolkata)
		Set<MenuItem> menuItems12 = new HashSet<>(List.of(
		// @formatter:off
			new MenuItem(null, "Chicken Reshmi Kabab", 510.00, ItemType.STARTER.name()),
			new MenuItem(null, "Prawn Fried Rice", 480.00, ItemType.DINNER.name())
		// @formatter:on
		));
		Restaurant restaurant12 = new Restaurant(null, "Mocambo", "Kolkata", Cuisine.CHINESE.getCuisineType(),
				Category.NONVEG, menuItems12);
		restaurants.add(restaurant12);

		// Restaurant 13: Old Harbour Hotel (Kochi)
		Set<MenuItem> menuItems13 = new HashSet<>(List.of(
		// @formatter:off
			new MenuItem(null, "Grilled Sea Bass", 950.00, ItemType.DINNER.name()),
			new MenuItem(null, "Malabar Paratha", 45.00, ItemType.DINNER.name())
		// @formatter:on
		));
		Restaurant restaurant13 = new Restaurant(null, "Old Harbour Hotel", "Kochi", Cuisine.COASTAL.getCuisineType(),
				Category.NONVEG, menuItems13);
		restaurants.add(restaurant13);

		// Restaurant 14: Indian Coffee House (Kochi)
		Set<MenuItem> menuItems14 = new HashSet<>(List.of(
		// @formatter:off
			new MenuItem(null, "Masala Dosa", 85.00, ItemType.BREAKFAST.name()),
			new MenuItem(null, "Vegetable Cutlet", 55.00, ItemType.SNACKS.name())
		// @formatter:on
		));
		Restaurant restaurant14 = new Restaurant(null, "Indian Coffee House", "Kochi", Cuisine.SI.getCuisineType(),
				Category.VEG, menuItems14);
		restaurants.add(restaurant14);

		// Restaurant 15: 1000 Oaks (Pune)
		Set<MenuItem> menuItems15 = new HashSet<>(List.of(
		// @formatter:off
			new MenuItem(null, "Dal Bukhara", 450.00, ItemType.DINNER.name()),
			new MenuItem(null, "Veg Nachos", 380.00, ItemType.SNACKS.name())
		// @formatter:on
		));
		Restaurant restaurant15 = new Restaurant(null, "1000 Oaks", "Pune", Cuisine.NI.getCuisineType(), Category.VEG,
				menuItems15);
		restaurants.add(restaurant15);

		// Restaurant 16: Marz-O-Rin (Pune)
		Set<MenuItem> menuItems16 = new HashSet<>(List.of(
		// @formatter:off
			new MenuItem(null, "Chicken Sandwich", 110.00, ItemType.SNACKS.name()),
			new MenuItem(null, "Pasta in White Sauce", 260.00, ItemType.DINNER.name())
		// @formatter:on
		));
		Restaurant restaurant16 = new Restaurant(null, "Marz-O-Rin", "Pune", Cuisine.FASTFOOD.getCuisineType(),
				Category.NONVEG, menuItems16);
		restaurants.add(restaurant16);

		// Save all in one go
		restaurantRepository.saveAll(restaurants);

	}

}
