package com.productapp.model.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Product {

	@Id
	@GeneratedValue(generator = "product_gen", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "product_gen", sequenceName = "product_seq", initialValue = 1, allocationSize = 1)
	@EqualsAndHashCode.Include
	private Integer productId;

	@Column(length = 160)
	private String productName;

	private double price;

	private double rating;

	// child entity is persisted before the parent entity
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "feature_id") // to give a different column name
	private Feature feature;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "product_id") // to add the foreign key to the many side
	private List<Offer> offers;

}
