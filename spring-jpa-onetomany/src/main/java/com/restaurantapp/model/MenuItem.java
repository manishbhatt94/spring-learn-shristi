package com.restaurantapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class MenuItem {

	@Id
	@GeneratedValue(generator = "menuitem_gen", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "menuitem_gen", sequenceName = "menuitem_seq", initialValue = 50)
	private Integer itemId;

	private String itemName;

	private double price;

	private String itemType; // starter, dessert

}
