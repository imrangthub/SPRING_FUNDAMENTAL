package com.imranmadbar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class HomeController {

	Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	public MyService myService;

	@Autowired
	public RedisTemplate<String, Object> redisTemplate;

	@GetMapping(value = "/get-info")
	public Customer getCustomerInfoController2(@RequestParam(name = "id") int id) {
		System.out.println("Calling......getCustomerInfoController: " + id + " data: "+myService.getCustomerByIdFromCustomerService2(id));

		return myService.getCustomerByIdFromCustomerService2(id);

	}

	@GetMapping(value = "/create-info")
	public String createCustomerInfoController2(@RequestParam(name = "id") int id) {
		System.out.println("Calling......createCustomerInfoController: " + id);

		return myService.createDataInCustomerService2(id);

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