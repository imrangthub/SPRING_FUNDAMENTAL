package com.imranmadbar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
public class WebClientController {

	@Autowired
	private WebClientService simpleService;
	
	@GetMapping("mono")
	public Mono<String> mono() {
	    return Mono.just("a");
	}
	
	
	@GetMapping(value = "/wc")
	public ResponseEntity getEmpwebClient() {
		String res = simpleService.getEmpwebClient();
		return ResponseEntity.status(200).body(res);
	}
	
	@GetMapping(value = "/wc2")
	public  Mono<String> getEmployeewebClient2() {
		return simpleService.getEmployeewebClient2();
	}
	
	@GetMapping(value = "/wc3")
	public  Mono<String>  getEmpEn() {
		 return simpleService.getEmpWebClient3();
	}

	@GetMapping(value = "/wcx")
	public ResponseEntity getEmpEnfoxx(@RequestParam(value = "del") Integer del) {
		String res = simpleService.getEmpEnfox(del);
		return ResponseEntity.status(200).body(res);
	}

}
