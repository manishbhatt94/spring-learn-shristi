package com.employeeapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Category {

	FE("FRONTEND"), BE("BACKEND"), ML("MACHINE LEARNING"), TESTING("TESTING"), DEVOPS("DEVOPS");

	private String category;

}
