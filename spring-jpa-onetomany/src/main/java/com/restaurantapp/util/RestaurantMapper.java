package com.restaurantapp.util;

import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.restaurantapp.model.MenuItem;
import com.restaurantapp.model.MenuItemDto;
import com.restaurantapp.model.Restaurant;
import com.restaurantapp.model.RestaurantDto;

@Component
public class RestaurantMapper {

	@Autowired
	private ModelMapper mapper;

	public RestaurantDto convertToRestaurantDto(Restaurant restaurant) {
		return mapper.map(restaurant, RestaurantDto.class);
	}

	public Restaurant convertToRestaurantEntity(RestaurantDto restaurantDto) {
		return mapper.map(restaurantDto, Restaurant.class);
	}

	public MenuItemDto convertToMenuItemDto(MenuItem menuItem) {
		return mapper.map(menuItem, MenuItemDto.class);
	}

	public MenuItem convertToMenuItemEntity(MenuItemDto menuItemDto) {
		return mapper.map(menuItemDto, MenuItem.class);
	}

	public RestaurantDto deepConvertToRestaurantDto(Restaurant restaurant) {
		RestaurantDto restaurantDto = convertToRestaurantDto(restaurant);
		Set<MenuItemDto> menuItemsDto = restaurant.getMenuItems().stream().map(this::convertToMenuItemDto)
				.collect(Collectors.toSet());
		restaurantDto.setMenuItems(menuItemsDto);
		return restaurantDto;
	}

}
