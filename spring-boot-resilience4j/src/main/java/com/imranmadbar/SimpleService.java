package com.imranmadbar;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class SimpleService {
	
	

    @CircuitBreaker(name = "getMsg", fallbackMethod = "fallbackForGetMsg")
    public String getMsg() {
    	
    	  RestTemplate restTemplate = new RestTemplate();
          String resourceUrl
            = "http://localhost:9991/intsc";

          ResponseEntity<String> response = restTemplate.getForEntity(resourceUrl, String.class);
          

          return response.getBody();
          
          
    }
    
    
    public String fallbackForGetMsg(Throwable ex) {

        return "Fal Back";
    }

    
    
    

}
