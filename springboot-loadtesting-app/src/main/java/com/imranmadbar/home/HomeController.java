package com.imranmadbar.home;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	Logger logger = LoggerFactory.getLogger(HomeController.class);

	@GetMapping("/")
	public String index() {
		logger.info("Spring Boot  Load testing Web Application");
		return "Spring Boot Load testing Web Application.";
	}

	@GetMapping("/home")
	public String home() {
		logger.info("Spring Boot  Load testing Home Web Application");
		return "Spring Boot Load testing Home Web Application.";
	}

}
