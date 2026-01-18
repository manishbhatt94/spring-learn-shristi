package com.restaurantapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.restaurantapp.model.Category;
import com.restaurantapp.model.RestaurantDto;
import com.restaurantapp.repository.IRestaurantRepository;

public class RestaurantServiceImpl implements IRestaurantService {

	@Autowired
	private IRestaurantRepository restaurantRepository;

	@Override
	public void addRestaurant(RestaurantDto restaurantDto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateRestaurant(RestaurantDto restaurantDto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteRestaurant(int restaurantId) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<RestaurantDto> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RestaurantDto getById(int restaurantId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RestaurantDto> getByCity(String city) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RestaurantDto> getByItemTypeCuisine(String itemType, String cuisine) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RestaurantDto> getByCityAndCuisine(String city, String cuisine) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RestaurantDto> getByCategory(Category category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RestaurantDto> getByCategoryItemType(Category category, String itemType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RestaurantDto> getByCategoryItemName(Category category, String itemName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RestaurantDto> getByItemNameContains(String itemName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RestaurantDto> getByItemNamePriceLessThan(String itemName, double price) {
		// TODO Auto-generated method stub
		return null;
	}

}
