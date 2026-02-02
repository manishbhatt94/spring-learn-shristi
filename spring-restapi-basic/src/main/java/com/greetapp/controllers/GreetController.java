package com.greetapp.controllers;

import java.util.Collections;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// the class having the rest end points
@RestController
public class GreetController {

	// returns data - String., list, Integer, list of book
	// any method name
	// add annotation with URL pattern
	// http://localhost:8080/greet
	// @RequestMapping(value ="greet", method = RequestMethod.GET)

	@GetMapping("/greet")
	String greet() {
		// call the methods of service
		return "Have a great day";
	}

	// data comes in the URL of the request - @PathVariable
	// http://localhost:8080/welcome/Sri Priya
	@GetMapping("/welcome/{username}")
	String welcomeUser(@PathVariable String username) {
		return "Welcome " + username;
	}

	// http://localhost:8080/show-details/username/Sri Priya/city/Bengaluru
	// placeholder name and parameter name are different use only
	// @PathVariable("name")
	@GetMapping("/show-details/username/{username}/city/{mycity}")
	String showDetails(@PathVariable String username, @PathVariable("mycity") String city) {
		return "Details of: " + username + " from " + city;
	}

	// to get data from form with get method - queryString
	// form field name and parameter name are same use only @RequestParam
	// http://localhost:8080/show-books/author?author=Kathy
	@GetMapping("/show-books/author")
	List<String> showBooks(@RequestParam String author) {
		if (author.trim().equalsIgnoreCase("kathy")) {
			return List.of("Java in action", "Spring");
		} else {
			return Collections.emptyList();
		}
	}

}
