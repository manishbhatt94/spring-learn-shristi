package com.spring.autowiring;

import org.springframework.stereotype.Component;

@Component
public class Triangle implements IShape {

	@Override
	public void calcArea(int x, int y) {

		double area = 0.5 * x * y;
		System.out.println("Area of Triangle: " + area);

	}

}
