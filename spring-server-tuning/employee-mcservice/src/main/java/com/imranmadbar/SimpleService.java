package com.imranmadbar;


import org.springframework.stereotype.Service;

@Service
public class SimpleService {
	
	public String getEmpEnfo() {
		
		 try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		return "Hellow From SimpleService";
	}

	
}
