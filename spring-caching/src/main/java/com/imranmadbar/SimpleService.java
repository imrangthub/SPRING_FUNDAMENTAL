package com.imranmadbar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class SimpleService {
	
	
    @Autowired
    private MyService myService;
    

	public String getDataFromService() {
	
		System.out.println("Calling......getDataFromService");
		
        String data1 = myService.getCachedData();


		return data1;
	}

	
	
	
	
	
	
	
	
	
	
	
	public String getDataFromRepository() {
		System.out.println("Calling......getDataFromRepository");
		return "getDataFromRepository";
	}

}
