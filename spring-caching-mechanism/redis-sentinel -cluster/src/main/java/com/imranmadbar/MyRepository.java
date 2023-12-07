package com.imranmadbar;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

@Repository
public class MyRepository {


	public Customer getCustomerById(int id) {
		try {
			TimeUnit.SECONDS.sleep(3);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

			

		List<Customer> customerList = new ArrayList<>();
		customerList.add(new Customer(1, "Rohim"));
		customerList.add(new Customer(2, "Korim"));
		customerList.add(new Customer(3, "Abdur"));
		
		Customer matchingObject = customerList.stream().
				filter(p -> p.getId()==id).
				findAny().orElse(null);
		
		
		System.out.println("Calling......getCustomerByIdFromCustomerRepository2: "+matchingObject);
		
		return matchingObject;

		


	}
	


	public String createDataInCustomerRepository2(int id) {
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Calling......createDataInCustomerRepository2: "+id);

		return "createDataInCustomerRepository2";
	}
	
	
}
