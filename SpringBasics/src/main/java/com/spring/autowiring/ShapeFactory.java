package com.spring.autowiring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ShapeFactory {

	// auto-wiring by type
	@Autowired
	@Qualifier("rectangle")
	private IShape shape; // = new Rectangle

	// auto-wiring by name - instance variable name & bean name are same
	@Autowired
	private IShape triangle;

	// auto-wiring by constructor
	private IShape myShape;

	// auto-wiring by constructor
	// - need to use @Qualifier(<name of implementation class bean>)
	// since there are multiple instance fields of IShape type
	public ShapeFactory(@Qualifier("parallelogram") IShape myShape) {
		super();
		this.myShape = myShape;
	}

	// auto-wiring using setter
	private IShape anotherShape;

	// auto-wiring using setter
	@Autowired
	public void setAnotherShape(@Qualifier("triangle") IShape anotherShape) {
		this.anotherShape = anotherShape;
	}

	void printArea(int x, int y) {
		shape.calcArea(x, y);
		triangle.calcArea(x, y);
		myShape.calcArea(x, y);
		anotherShape.calcArea(x, y);
	}

}
