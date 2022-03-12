package com.imranmadbar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	Logger logger = LoggerFactory.getLogger(HomeController.class);

	@GetMapping("/")
	public String index() {
		logger.info("Hello World Spring Boot Web Application");
		return "Hello World Spring  Web Application.";
	}
	
	
	@GetMapping("/home")
	public String home() {
		logger.info("Welcome to Spring  Web Application");
		return "Welcome to Spring  Web Application.";
	}
	
	
	
}
