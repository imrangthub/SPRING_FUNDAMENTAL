package com.imranmadbar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	
	
	@Autowired
	public MyService myService;
	
	@Autowired
	public RedisTemplate<String, Object> redisTemplate;

	
	
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
	
	
	@GetMapping(value = "/check-conn")
	public String checkConn() {
		 System.out.println("Calling......checkConn");

		

		// redisTemplate.opsForValue().set("data", "My data");

		 redisTemplate.setDefaultSerializer(StringRedisSerializer.UTF_8);
		 
			String data1Val = (String) redisTemplate.opsForValue().get("data1");
			
			System.out.print("data1: "+data1Val);

		 
		return data1Val;
	
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