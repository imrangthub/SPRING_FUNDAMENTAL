package com.imranmadbar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository myRepository;

	public String getDataFromCustomerService(String csid) {
		System.out.println("Calling......getDataFromCustomerService: "+csid);
		return myRepository.getDataFromCustomerRepository(csid);
	}

	public String createDataInCustomerService() {
		System.out.println("Calling......createDataInCustomerService");
		return myRepository.createDataInCustomerRepository();
	}

}