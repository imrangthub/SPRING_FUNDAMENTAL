package com.imran.moduleserviceone.home;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.imran.appcore.CoreCommonFunction;

@RestController
public class HomeController implements CoreCommonFunction {

	@Autowired
	private RestTemplate restTemplate;

	Logger logger = LoggerFactory.getLogger(HomeController.class);

	@GetMapping(value = "/")
	public String welcomeMsg() {
		logger.info("Welcome to ModuleOneApp");
		return "Welcome to ModuleOneApp";
	}

	@GetMapping(value = "/2")
	public String helloMsg() {
		logger.info("Welcome to ModuleOneApp | " + getSimpleMsg());
		return "Welcome to ModuleOneApp | " + getSimpleMsg();
	}

	@GetMapping(value = "/3")
	public String restCall1() {

		String url = "https://reqres.in/api/users?page=2";
		String resObj = this.restTemplate.getForObject(url, String.class);

		logger.info("Rest1:" + resObj);

		return resObj;
	}

}
