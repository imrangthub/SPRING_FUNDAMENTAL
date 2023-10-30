package com.imranmadbar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	Logger logger = LoggerFactory.getLogger(HomeController.class);

	@GetMapping(value = "/")
	public String welcomeMsg() {
		logger.info("Welcome to MicroserviceOneApplication");
		return "Welcome to MicroserviceOneApplication";
	}

	@GetMapping(value = "/home")
	public String helloMsg() {
		logger.info("Welcome Home to Spring Boot  MicroserviceOneApplication");
		return "Welcome Home to Spring Boot  MicroserviceOneApplication";
	}
	
	@GetMapping(value = "/one")
	public String mcOne() {
		logger.info("Welcome Home to Spring Boot  MicroserviceOneApplication");
		return "Welcome Home to Spring Boot  MicroserviceOneApplication";
	}

}
