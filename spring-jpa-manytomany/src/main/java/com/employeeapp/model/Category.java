package com.employeeapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Category {

	FE("Frontend"), BE("Backend"), AIML("AI/ML"), TESTING("Testing"), DEVOPS("Devops"), CLOUD("Cloud"),
	PROGRAMMING("Programming"), MANAGEMENT("Management");

	private String category;

}
