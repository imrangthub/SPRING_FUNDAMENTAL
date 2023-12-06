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
@RequestMapping("/customer-api")
public class CustomerController {
	

	Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	
	
	@Autowired
	public CustomerService customerService;
	
	@Autowired
	public RedisTemplate<String, Object> redisTemplate;
	
	
	@GetMapping(value = "/get-info")
	public String getCustomerInfoController(@RequestParam(name = "csid") String csid) {
		 System.out.println("Calling......getCustomerInfoController: "+csid);
		 
		return customerService.getDataFromCustomerService(csid);
	
	}
	
	
	@GetMapping(value = "/create-info")
	public String createCustomerInfoController() {
		 System.out.println("Calling......createCustomerInfoController");
		 
		return customerService.createDataInCustomerService();
	
	}
	
	

}
