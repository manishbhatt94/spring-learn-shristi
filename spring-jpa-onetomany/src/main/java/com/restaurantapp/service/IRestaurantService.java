package com.restaurantapp.service;

import java.util.List;

import com.restaurantapp.model.Category;
import com.restaurantapp.model.RestaurantDto;

public interface IRestaurantService {

	void addRestaurant(RestaurantDto restaurantDto);

	void updateRestaurant(RestaurantDto restaurantDto);

	void deleteRestaurant(int restaurantId);

	List<RestaurantDto> getAll();

	RestaurantDto getById(int restaurantId);

	List<RestaurantDto> getByCity(String city);

	List<RestaurantDto> getByItemTypeCuisine(String itemType, String cuisine); // Starter, Chinese

	List<RestaurantDto> getByCityAndCuisine(String city, String cuisine); // Chennai, Chinese

	List<RestaurantDto> getByCategory(Category category); // veg / nonveg

	List<RestaurantDto> getByCategoryItemType(Category category, String itemType); // veg / nonveg, Lunch

	List<RestaurantDto> getByCategoryItemName(Category category, String itemName); // veg / nonveg, biryani

	List<RestaurantDto> getByItemNameContains(String itemName); // paneer

	List<RestaurantDto> getByItemNamePriceLessThan(String itemName, double price);

}
