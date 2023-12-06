package com.imranmadbar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class CustomerService2 {

	@Autowired
	private CustomerRepository2 myRepository;

	@Cacheable(value = "simple-redis-caching:get-info", key="#id")
	public Customer getCustomerByIdFromCustomerService2(int id) {
		System.out.println("Calling......getCustomerByIdFromCustomerService2: "+id);
		return myRepository.getCustomerById(id);
	}
	
	

	@CacheEvict(value = "simple-redis-caching:get-info", key="#id")
	public String createDataInCustomerService2(int id) {
		System.out.println("Calling......createDataInCustomerService2");
		return myRepository.createDataInCustomerRepository2(id);
	}

}