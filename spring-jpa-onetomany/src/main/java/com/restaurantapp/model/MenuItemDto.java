package com.restaurantapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MenuItemDto {

	private Integer itemId;

	private String itemName;

	private double price;

	private String itemType; // starter, dessert

}
