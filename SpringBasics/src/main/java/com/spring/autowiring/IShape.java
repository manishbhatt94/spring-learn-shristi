package com.spring.autowiring;

// We should NOT @Component annotation on an interface
// since interfaces cannot be instantiated.
// @Component -- Don't add this on interfaces
public interface IShape {

	void calcArea(int x, int y);

}
