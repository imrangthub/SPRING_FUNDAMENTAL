package com.imranmadbar.fing;


import org.springframework.stereotype.Service;

import com.imranmadbar.fing.IntregrationFeingClient;

@Service
public class FeingService {
	
	public FeingService(IntregrationFeingClient intregrationFeingClient) {
		this.intregrationFeingClient = intregrationFeingClient;
		
	}
	
	private IntregrationFeingClient intregrationFeingClient;
	
	public String getEmpEnfo1() {
		
		return intregrationFeingClient.getEmpEnfo1();

	}
	
	public String getEmpEnfo3() {
		return intregrationFeingClient.getEmpEnfo3();

	}
	
	

	
}
