package com.spring.autowiring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ShapeFactory {

	// Auto-wiring by type.
	// @Qualifier(<bean-name>) is required since the interface type IShape has
	// multiple implementation classes.
	@Autowired
	@Qualifier("rectangle")
	// Field based auto-wiring - just field is present - with neither a setter for
	// this field, nor a parameterized constructor that initializes this field.
	private IShape shape; // = new Rectangle

	// Auto-wiring by name.
	// - Instance variable name & bean name are same.
	@Autowired
	// Field based auto-wiring - just field is present - with neither a setter for
	// this field, nor a parameterized constructor that initializes this field.
	private IShape triangle;

	// Auto-wiring by constructor.
	private IShape myShape;

	// Auto-wiring by constructor.
	// - Need to use @Qualifier(<name of implementation class bean>)
	// since there are multiple instance fields of IShape type.
	// - Note: when injecting dependency using constructor, we don't
	// put @Autowired annotation above the construct.
	public ShapeFactory(@Qualifier("parallelogram") IShape myShape) {
		super();
		this.myShape = myShape;
	}

	// Auto-wiring using setter
	private IShape anotherShape;

	// Auto-wiring using setter
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
