package com.spring.autowiring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ShapeFactory {

	@Autowired
	@Qualifier("rectangle")
	private IShape shape;

	void printArea(int x, int y) {
		shape.calcArea(x, y);
	}

}
