package com.imranmadbar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	Logger logger = LoggerFactory.getLogger(HomeController.class);

	@GetMapping(value = "/")
	public String welcomeMsg() {
		logger.info("Welcome to MicroservciceTwoApplication");
		return "Welcome to MicroservciceTwoApplication";
	}

	@GetMapping(value = "/home")
	public String helloMsg() {
		logger.info("Welcome Home to Spring Boot  MicroservciceTwoApplication");
		return "Welcome Home to Spring Boot  MicroservciceTwoApplication";
	}
	
	@GetMapping(value = "/two")
	public String mcTwo() {
		logger.info("Welcome Home to Spring Boot  MicroservciceTwoApplication");
		return "Welcome Home to Spring Boot  MicroservciceTwoApplication";
	}

}
