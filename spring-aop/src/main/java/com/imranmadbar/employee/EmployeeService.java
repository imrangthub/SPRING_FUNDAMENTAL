package com.imranmadbar.employee;

import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

	public String getInfo() {
		System.out.println("Get Employee Info from Service");
		return "Get Employee";
	}
	
	
}
