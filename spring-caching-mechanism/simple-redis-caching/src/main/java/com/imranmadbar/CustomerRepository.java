package com.imranmadbar;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepository {

	@Cacheable(value = "customer1")
	public String getDataFromCustomerRepository(String csid) {
		try {
			TimeUnit.SECONDS.sleep(3);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

			



		
		System.out.println("Calling......getDataFromCustomerRepository: "+csid);
		

		return "getDataFromCustomerRepository: "+csid;
	}
	


	@CacheEvict(value = "customer1")
	public String createDataInCustomerRepository() {
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Calling......createDataInCustomerRepository");

		return "createDataInCustomerRepository";
	}

}
