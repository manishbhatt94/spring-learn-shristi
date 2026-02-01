package com.greetapp.controllers;

import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GreetController {

	// return value should be a string - name of the view page
	@GetMapping("/greet")
	public String greetMessage(Model model) {
		// call the service layer and get the data
		String message = "Have a great day";
		// bundle this data - attach it to a model
		model.addAttribute("myMessage", message);
		// return the view page name
		return "success";
	}

	// return value should be a string - name of the view page
	@GetMapping("/show-books")
	public String showBooks(ModelMap model) {
		// call the service layer and get the data
		// bundle this data - attach it to a model
		model.addAttribute("books", Arrays.asList("Java", "Spring", "Microservices"));
		// return the view page name
		return "success";
	}

	// return value is ModelAndView object - passing model and view together
	@GetMapping("/welcome")
	public ModelAndView welcome() {
		// call the service layer and get the data
		String data = "Welcome to MVC";
		// bundle this data - attach it to a ModelAndView object
		ModelAndView modelAndView = new ModelAndView("success", "myMessage", data);
		// return the model and view object
		return modelAndView;
	}

}
