package com.studentapp.model;

import jakarta.persistence.Column;
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
public class Address {

	@Id
	@GeneratedValue(generator = "address_seq_gen", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "address_seq_gen", sequenceName = "addr_seq", initialValue = 1, allocationSize = 1)
	private Integer addressId;

	@Column(length = 20)
	private String houseNumber;

	@Column(length = 150)
	private String street;

	@Column(length = 120)
	private String locality;

	@Column(length = 100)
	private String city;

	@Column(length = 100)
	private String state;

	private Integer pincode;

}
