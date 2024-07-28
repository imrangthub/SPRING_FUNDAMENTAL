package com.imranmadbar;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class FeingService {

	public FeingService(IntregrationFeingClient intregrationFeingClient) {
		this.intregrationFeingClient = intregrationFeingClient;

	}

	private IntregrationFeingClient intregrationFeingClient;
	
	
	public String getEmpEnfo0() {
//		return intregrationFeingClient.intsc0();
		String res =intregrationFeingClient.intsc0().getBody();
		return res;
	}
	
	
	public ResponseEntity getEmpEnfResEndPoint() {
		return ResponseEntity.ok("hello");
	}
	
	

	public String getEmpEnfo() {
		return intregrationFeingClient.getEmpEnfo();

	}

	public String getEmpEnfo1() {
		return intregrationFeingClient.getEmpEnfo1();

	}

	public String getEmpEnfo2() {
		return intregrationFeingClient.getEmpEnfo2();
	}

	public String getEmpEnfo3() {
		return intregrationFeingClient.getEmpEnfo3();
	}

	public String getEmpEnfo4() {
		return intregrationFeingClient.getEmpEnfo4();
	}

	public String getEmpEnfo5() {
		return intregrationFeingClient.getEmpEnfo5();
	}

	public ResponseEntity delayx(@RequestParam(value = "del", required = false) Integer del) {
		return intregrationFeingClient.delayx(del);
	}
	
	
	public ResponseEntity delayx2(@RequestParam(value = "del", required = false) Integer del) {
		return intregrationFeingClient.delayx2(del);
	}
	
	public ResponseEntity delayx3Old() {
		return intregrationFeingClient.delayx3();
	}
	
	public String delayx3() {
		
		ResponseEntity data = intregrationFeingClient.delayx3();
		return data.toString();
	}
	
	
	public MyDto delayx4() {
		return intregrationFeingClient.delayx4();
	}
	

	public String delayx5() {
		return intregrationFeingClient.delayx5();
	}
	
	
	

	public String delayx6() {

		 try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return "Delay success for 3second";

	}




}
