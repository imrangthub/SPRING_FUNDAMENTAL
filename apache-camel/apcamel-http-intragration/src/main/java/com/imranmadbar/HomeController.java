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
		logger.info("Welcome to ApacheCamelSimpleApplication");
		return "Welcome to ApacheCamelSimpleApplication";
	}

	@GetMapping(value = "/home")
	public String welcomeMsgHome() {
		logger.info("Welcome to ApacheCamelSimpleApplication Home");
		return "Welcome to ApacheCamelSimpleApplication Home";
	}

}
