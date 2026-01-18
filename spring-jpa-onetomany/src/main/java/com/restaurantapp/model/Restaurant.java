package com.restaurantapp.model;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Restaurant {

	@Id
	@GeneratedValue(generator = "restaurant_gen", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "restaurant_gen", sequenceName = "restaurant_seq", initialValue = 1)
	private Integer restaurantId;

	private String restaurantName;

	private String city;

	/**
	 * Taken from enum {@code Cuisine}. But here, data type is {@code String}.
	 */
	private String cuisine; // Indian, Italian, etc.

	/**
	 * Taken from enum {@code Category}. Here, data type is also {@code Category}.
	 */
	@Enumerated(EnumType.STRING)
	private Category category; // veg, non-veg

	@OneToMany
	private Set<MenuItem> menuItems;

}
