package com.imranmadbar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

	Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	
	

	@GetMapping(value = "/admin")
	public String welcomeMsg() {
		logger.info("Welcome to Admin");
		return "Welcome to Admin";
	}

	@GetMapping(value = "/manager")
	public String helloMsg() {
		logger.info("Welcome Manager");
		return "Welcome  Manager";
	}

}
