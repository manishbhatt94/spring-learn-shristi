package com.spring.autowiring;

import org.springframework.stereotype.Component;

@Component
public class Rectangle implements IShape {

	@Override
	public void calcArea(int x, int y) {

		int area = x * y;
		System.out.println("Area of Rectangle: " + area);

	}

}
