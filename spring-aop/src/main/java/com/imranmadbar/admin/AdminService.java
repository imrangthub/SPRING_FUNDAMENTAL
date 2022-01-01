package com.imranmadbar.admin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
	
    private Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    
	public String getInfo() {
		
//		LOGGER.info("In Business - {}", "GET ADMIN INFO");
		  
		System.out.println("Get Admin Info from Service");
		return "Get Admin Info";
	}
	
	

}
