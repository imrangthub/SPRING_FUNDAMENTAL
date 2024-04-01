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
		logger.info("Welcome to MicroserviceOneApplication Root / url");
		return "Welcome to MicroserviceOneApplication Root / url";
	}

	@GetMapping(value = "/home")
	public String helloMsg() {
		logger.info("This is MicroserviceOneApplication Home");
		return "This is MicroserviceOneApplication Home";
	}
	
	@GetMapping(value = "/r1")
	public String mcOne() {
		logger.info("This is MicroserviceOneApplication Route-One");
		return "his is MicroserviceOneApplication Route-One";
	}
	
	
	@GetMapping(value = "/r2")
	public String mcOne2() {
		logger.info("This is MicroserviceOneApplication Route-Two");
		return "This is MicroserviceOneApplication Route-Two";
	}

}
