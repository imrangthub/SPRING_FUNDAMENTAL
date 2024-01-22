package com.imranmadbar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private SimpleService simpleService;
	

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
	
	@GetMapping(value = "/emp")
	public String getEmpEnfo() {
		 
		 simpleService.getEmpEnfo();
		
		logger.info("Welcome Home to Spring Boot  SimpleWebApplication");
		return "Welcome Home to Spring Boot  SimpleWebApplication";
	}
	
	@GetMapping(value = "/emp1")
	public String getEmpEnfo1() {
		 
		 simpleService.getEmpEnfo1();
		
		logger.info("Welcome Home to Spring Boot  SimpleWebApplication");
		return "Welcome Home to Spring Boot  SimpleWebApplication";
	}
	
	@GetMapping(value = "/emp2")
	public String getEmpEnfo2() {
		 
		 simpleService.getEmpEnfo2();
		
		logger.info("Welcome Home to Spring Boot  SimpleWebApplication");
		return "Welcome Home to Spring Boot  SimpleWebApplication";
	}
	
	@GetMapping(value = "/emp3")
	public String getEmpEnfo3() {
		 
		 simpleService.getEmpEnfo3();
		
		logger.info("Welcome Home to Spring Boot  SimpleWebApplication");
		return "Welcome Home to Spring Boot  SimpleWebApplication";
	}

}
