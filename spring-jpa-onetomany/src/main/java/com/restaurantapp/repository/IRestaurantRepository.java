package com.restaurantapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.restaurantapp.model.Category;
import com.restaurantapp.model.Restaurant;

public interface IRestaurantRepository extends JpaRepository<Restaurant, Integer> {

	List<Restaurant> findByCity(String city);

	List<Restaurant> findByCityAndCuisine(String city, String cuisine);

	List<Restaurant> findByCategory(Category category);

	@Query("""
			SELECT r FROM Restaurant r INNER JOIN r.menuItems i
			ON r.restauranId = i.restaurantId
			WHERE i.itemType = ?1 AND r.cuisine = ?2
			""")
	List<Restaurant> findByItemTypeCuisine(String itemType, String cuisine);

}
