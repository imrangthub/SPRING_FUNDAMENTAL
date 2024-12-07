package com.imranmadbar.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import lombok.var;

@RestController
@RequestMapping("/api")
public class MyRestController {

	Logger logger = LoggerFactory.getLogger(MyRestController.class);

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private WebClient webClient;
	
	
	@GetMapping()
	public String restCall() {
		String url = "https://reqres.in/api/users?page=1";
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("user-agent", "Application");
		HttpEntity<String> requestEntity = new HttpEntity<>(headers);

		ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, requestEntity, String.class);
		
		logger.info("Rest1:"+response.getBody());

		return response.getBody();
	}
	

	@GetMapping(value = "/1")
	public String restCall1() {
		String url = "https://reqres.in/api/users?page=1";
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("user-agent", "Application");
		HttpEntity<String> requestEntity = new HttpEntity<>(headers);

		ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, requestEntity, String.class);
		
		logger.info("Rest1:"+response.getBody());

		return response.getBody();
	}
	
	
	
	
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
	
	
	
	@GetMapping(value = "/{id}")
	public String restCall3(@PathVariable String id) {
		if (id==null)id="1";
		String resObj = webClient.get()
				.uri("/users?page="+id)
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				.retrieve()
				.bodyToMono(String.class)
				.block();
		
		logger.info("req-url: https://reqres.in/api/users?page="+id+" res-data:"+ resObj);

		return resObj;
	}
	
	
	

	

}


