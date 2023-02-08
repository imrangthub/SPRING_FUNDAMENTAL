package com.imran.moduleservicetwo.home;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.imran.appshared.SharedFunctions;

@RestController
public class HomeController implements SharedFunctions {

	@Autowired
	private WebClient webClient;

	Logger logger = LoggerFactory.getLogger(HomeController.class);

	@GetMapping(value = "/")
	public String welcomeMsg() {
		logger.info("Welcome to ModuleTwoApp");
		return "Welcome to ModuleTwoApp";
	}

	@GetMapping(value = "/2")
	public String helloMsg() {
		logger.info("Welcome  to Spring Boot  ModuleTwoApp | " + getSimpleSharedMsg());
		return "Welcome  to Spring Boot  ModuleTwoApp | " + getSimpleSharedMsg();
	}

	@GetMapping(value = "/3")
	public String restCall2() {
		String resObj = webClient.get().uri("/users?page=2")
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).retrieve().bodyToMono(String.class)
				.block();
		logger.info("Rest2:" + resObj);
		return resObj;

	}

}
