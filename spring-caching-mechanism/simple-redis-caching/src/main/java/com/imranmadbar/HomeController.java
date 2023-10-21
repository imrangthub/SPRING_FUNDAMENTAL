package com.imranmadbar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	
	
	@Autowired
	public MyService myService;
	

	
	
	@GetMapping(value = "/get-data")
	public String getDataFromController() {
		 System.out.println("Calling......getDataFromController");
		 
		return myService.getDataFromMyService();
	
	}
	
	@GetMapping(value = "/create-data")
	public String createDataFromController() {
		 System.out.println("Calling......createDataFromController");
		 
		return myService.createDataFromMyService();
	
	}
	
	
	

	
	
	
	
	
	
	
	
	
	
	@GetMapping(value = "/")
	public String welcomeMsg() {
		logger.info("Welcome to SimpleWebApplication");
		return "Welcome to SimpleWebApplication";
	}

	@GetMapping(value = "/home")
	public String helloMsg() {
		logger.info("Welcome Home to Spring Boot  SimpleWebApplication");
		return "Welcome Home to Spring Boot  SimpleWebApplication";
	}

}