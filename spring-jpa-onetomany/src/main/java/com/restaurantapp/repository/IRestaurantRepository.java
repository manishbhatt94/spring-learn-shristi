package com.restaurantapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.restaurantapp.model.Category;
import com.restaurantapp.model.Restaurant;

@Repository
public interface IRestaurantRepository extends JpaRepository<Restaurant, Integer> {

	List<Restaurant> findByCity(String city);

	List<Restaurant> findByCityAndCuisine(String city, String cuisine);

	List<Restaurant> findByCategory(Category category);

	@Query("""
			SELECT r FROM Restaurant r JOIN r.menuItems mi
			WHERE mi.itemType = ?1 AND r.cuisine = ?2
			""")
	List<Restaurant> findByItemTypeCuisine(String itemType, String cuisine);

	@Query("""
			SELECT r FROM Restaurant r JOIN r.menuItems mi
			WHERE r.category = ?1 AND mi.itemType = ?2
			""")
	List<Restaurant> findByCategoryItemType(Category category, String itemType);

	@Query("""
			SELECT r FROM Restaurant r JOIN r.menuItems mi
			WHERE r.category = ?1 AND mi.itemName = ?2
			""")
	List<Restaurant> findByCategoryItemName(Category category, String itemName);

	@Query("""
			SELECT r FROM Restaurant r JOIN r.menuItems mi
			WHERE mi.itemName LIKE %?1%
			""")
	List<Restaurant> findByItemNameContains(String itemName);

	@Query("""
			SELECT r FROM Restaurant r JOIN r.menuItems mi
			WHERE mi.price <= ?2 AND mi.itemName LIKE %?1%
			""")
	List<Restaurant> findByItemNamePriceLessThan(String itemName, double price);

}
