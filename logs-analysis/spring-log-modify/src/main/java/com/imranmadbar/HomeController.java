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
		logger.info("Welcome to SimpleWebApplication");
		return "Welcome to SimpleWebApplication";
	}

	@GetMapping(value = "/home")
	public String helloMsg() {

		
        try {
        	 throw new RuntimeException("Errrrrrrrrrr");
        }catch (Exception e) {
    		logger.info(e.getMessage());
        	//e.printStackTrace();
        }
		
		return "Welcome Home to Spring Boot  SimpleWebApplication";
	}

}
