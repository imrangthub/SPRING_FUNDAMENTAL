package com.imranmadbar.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequestMapping("/rest")
public class MyRestController {

	Logger logger = LoggerFactory.getLogger(MyRestController.class);

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private WebClient webClient;
	
	
	
	@GetMapping(value = "/2")
	public String restCall2() {
		
		String resObj = webClient.get()
				.uri("/users?page=2")
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				.retrieve()
				.bodyToMono(String.class)
				.block();

		logger.info("Rest2:"+resObj);

		return resObj;
	}
	
	
	

	@GetMapping(value = "/1")
	public String restCall1() {
	
		String url = "https://reqres.in/api/users?page=2";
		String resObj = this.restTemplate.getForObject(url, String.class);
		
		logger.info("Rest1:"+resObj);

		return resObj;
	}
	
	

}


