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
@RequestMapping("/customer-api2")
public class CustomerController2 {
	

	Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	
	
	@Autowired
	public CustomerService2 customerService2;
	
	@Autowired
	public RedisTemplate<String, Object> redisTemplate;
	
	
	@GetMapping(value = "/get-info")
	public Customer getCustomerInfoController2(@RequestParam(name = "id") int id) {
		 System.out.println("Calling......getCustomerInfoController2: "+id);
		 
		return customerService2.getCustomerByIdFromCustomerService2(id);
	
	}

	
	@GetMapping(value = "/create-info")
	public String createCustomerInfoController2(@RequestParam(name = "id") int id) {
		 System.out.println("Calling......createCustomerInfoController2: "+id);
		 
		return customerService2.createDataInCustomerService2(id);
	
	}
	
	

}
