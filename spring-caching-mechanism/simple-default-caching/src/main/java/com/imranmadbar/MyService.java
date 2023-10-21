package com.imranmadbar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyService {

	@Autowired
	private MyRepository myRepository;

	public String getDataFromMyService() {
		System.out.println("Calling......getDataFromMyService");
		return myRepository.getDataFromMyRepository();
	}

	public String createDataFromMyService() {
		System.out.println("Calling......createDataFromMyService");
		return myRepository.createDataFromMyRepository();
	}

}