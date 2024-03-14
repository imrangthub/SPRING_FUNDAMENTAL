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
	
	
//	public ResponseEntity getEmpEnfo0() {
//		return ResponseEntity.ok("hello");
//	}
//	
	

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

	public ResponseEntity getEmpEnfox(@RequestParam(value = "del", required = false) Integer del) {
		return intregrationFeingClient.getEmpEnfox(del);
	}

	public ResponseEntity getEmpEnfoxn(@RequestParam(value = "del", required = false) Integer del) {
		return intregrationFeingClient.getEmpEnfoxn(del);
	}

}
