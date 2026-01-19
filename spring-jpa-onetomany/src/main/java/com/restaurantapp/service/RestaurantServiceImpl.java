package com.restaurantapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurantapp.model.Category;
import com.restaurantapp.model.Restaurant;
import com.restaurantapp.model.RestaurantDto;
import com.restaurantapp.repository.IRestaurantRepository;
import com.restaurantapp.util.RestaurantMapper;

@Service
public class RestaurantServiceImpl implements IRestaurantService {

	@Autowired
	private IRestaurantRepository restaurantRepository;

	@Autowired
	private RestaurantMapper mapper;

	@Override
	public void addRestaurant(RestaurantDto restaurantDto) {
		Restaurant restaurant = mapper.convertToRestaurantEntity(restaurantDto);
		restaurantRepository.save(restaurant);
	}

	@Override
	public void updateRestaurant(RestaurantDto restaurantDto) {
		Restaurant restaurant = mapper.convertToRestaurantEntity(restaurantDto);
		restaurantRepository.save(restaurant);
	}

	@Override
	public void deleteRestaurant(int restaurantId) {
		restaurantRepository.deleteById(restaurantId);
	}

	@Override
	public List<RestaurantDto> getAll() {
		return restaurantRepository.findAll().stream().map(mapper::convertToRestaurantDto).toList();
	}

	@Override
	public RestaurantDto getById(int restaurantId) {
		return restaurantRepository.findById(restaurantId).map(mapper::deepConvertToRestaurantDto).orElse(null);
	}

	@Override
	public List<RestaurantDto> getByCity(String city) {
		return restaurantRepository.findByCity(city).stream().map(mapper::convertToRestaurantDto).toList();
	}

	@Override
	public List<RestaurantDto> getByItemTypeCuisine(String itemType, String cuisine) {
		return restaurantRepository.findByItemTypeCuisine(itemType, cuisine).stream()
				.map(mapper::convertToRestaurantDto).toList();
	}

	@Override
	public List<RestaurantDto> getByCityAndCuisine(String city, String cuisine) {
		return restaurantRepository.findByCityAndCuisine(city, cuisine).stream().map(mapper::convertToRestaurantDto)
				.toList();
	}

	@Override
	public List<RestaurantDto> getByCategory(Category category) {
		return restaurantRepository.findByCategory(category).stream().map(mapper::convertToRestaurantDto).toList();
	}

	@Override
	public List<RestaurantDto> getByCategoryItemType(Category category, String itemType) {
		return restaurantRepository.findByCategoryItemType(category, itemType).stream()
				.map(mapper::convertToRestaurantDto).toList();
	}

	@Override
	public List<RestaurantDto> getByCategoryItemName(Category category, String itemName) {
		return restaurantRepository.findByCategoryItemName(category, itemName).stream()
				.map(mapper::convertToRestaurantDto).toList();
	}

	@Override
	public List<RestaurantDto> getByItemNameContains(String itemName) {
		return restaurantRepository.findByItemNameContains(itemName).stream().map(mapper::convertToRestaurantDto)
				.toList();
	}

	@Override
	public List<RestaurantDto> getByItemNamePriceLessThan(String itemName, double price) {
		return restaurantRepository.findByItemNamePriceLessThan(itemName, price).stream()
				.map(mapper::convertToRestaurantDto).toList();
	}

}
