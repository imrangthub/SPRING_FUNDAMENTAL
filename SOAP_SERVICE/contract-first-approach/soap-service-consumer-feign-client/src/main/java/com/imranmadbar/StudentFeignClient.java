package com.imranmadbar;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "product-service", url = "http://localhost:8080/ws")
public interface StudentFeignClient {

	@PostMapping(value = "/ws", consumes = "text/xml; charset=UTF-8")
	String doRequest(@RequestBody String request);
	
	
	
	
}
