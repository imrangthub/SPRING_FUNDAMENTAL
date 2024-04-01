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
		logger.info("Welcome to MicroserviceTwoApplication Root / url");
		return "Welcome to MicroserviceTwoApplication Root / url";
	}

	@GetMapping(value = "/home")
	public String helloMsg() {
		logger.info("This is MicroserviceTwoApplication Home");
		return "This is MicroserviceTwoApplication Home";
	}
	
	@GetMapping(value = "/r1")
	public String mcOne() {
		logger.info("This is MicroserviceTwoApplication Route-One");
		return "his is MicroserviceTwoApplication Route-One";
	}
	
	
	@GetMapping(value = "/r2")
	public String mcOne2() {
		logger.info("This is MicroserviceTwoApplication Route-Two");
		return "This is MicroserviceTwoApplication Route-Two";
	}

}
