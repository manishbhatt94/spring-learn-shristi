package com.studentapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AddressDto {

	private Integer addressId;

	private String houseNumber;

	private String street;

	private String locality;

	private String city;

	private String state;

	private String pincode;

}
