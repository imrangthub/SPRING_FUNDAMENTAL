package com.imranmadbar;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "IntregrationFeingClient", url = "http://localhost:8181")
public interface IntregrationFeingClient {
	
	
	@GetMapping(value = "/intsc0")
	public ResponseEntity<String> intsc0();

	@GetMapping(value = "/intsc1")
	String getEmpEnfo();

	@GetMapping(value = "/intsc1/delay200")
	String getEmpEnfo1();

	@GetMapping(value = "/intsc1/delay2000")
	public String getEmpEnfo2();

	@GetMapping(value = "/intsc1/delay3000")
	public String getEmpEnfo3();

	@GetMapping(value = "/intsc1/delay4000")
	public String getEmpEnfo4();

	@GetMapping(value = "/intsc1/delay5000")
	public String getEmpEnfo5();

	@GetMapping(value = "/intsc1/delayx")
	public ResponseEntity getEmpEnfox(@RequestParam(value = "del", required = false) Integer del);

	@GetMapping(value = "/intsc1/delayx2")
	public ResponseEntity getEmpEnfoxn(@RequestParam(value = "del", required = false) Integer del);

}
