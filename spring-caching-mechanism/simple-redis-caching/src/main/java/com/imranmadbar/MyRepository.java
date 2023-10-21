package com.imranmadbar;

import java.util.concurrent.TimeUnit;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

@Repository
public class MyRepository {

	
	@Cacheable(value = "data1")
	public String getDataFromMyRepository() {
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Calling......getDataFromMyRepository");
		
		return "getDataFromMyRepository";
	}
	
	
    @CacheEvict(value = "data1")
	public String createDataFromMyRepository() {
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Calling......createDataFromMyRepository");
		
		return "createDataFromMyRepository";
	}

	

	
	
	
	
}
