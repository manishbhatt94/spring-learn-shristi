package com.restaurantapp.model;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RestaurantDto {

	private Integer restaurantId;

	private String restaurantName;

	private String city;

	private String cuisine; // Indian, Italian, etc.

	private Category category; // veg, non-veg

	private Set<MenuItemDto> menuItems;

}
