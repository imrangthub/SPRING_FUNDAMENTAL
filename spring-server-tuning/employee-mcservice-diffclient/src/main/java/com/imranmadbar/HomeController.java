package com.imranmadbar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HomeController {

	Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private Environment environment;

	@Autowired
	private SimpleService simpleService;

	@GetMapping(value = "/emp")
	public String getEmpEnfo() {

		simpleService.getEmpEnfo();

		logger.info("Welcome Home to Spring Boot  getEmpEnfo");
		return "Welcome Home to Spring Boot  getEmpEnfo";
	}

	@GetMapping(value = "/emp1")
	public String getEmpEnfo1() {

		simpleService.getEmpEnfo1();

		logger.info("Welcome Home to Spring Boot  getEmpEnfo1");
		return "Welcome Home to Spring Boot  getEmpEnfo1";
	}

	@GetMapping(value = "/emp2")
	public String getEmpEnfo2() {

		simpleService.getEmpEnfo2();

		logger.info("Welcome Home to Spring Boot  getEmpEnfo2");
		return "Welcome Home to Spring Boot  getEmpEnfo2";
	}

	@GetMapping(value = "/emp3")
	public String getEmpEnfo3() {

		simpleService.getEmpEnfo3();

		logger.info("Welcome Home to Spring Boot  getEmpEnfo3");
		return "Welcome Home to Spring Boot  getEmpEnfo3";
	}

	@GetMapping(value = "/emp4")
	public String getEmpEnfo4() {

		simpleService.getEmpEnfo4();

		logger.info("Welcome Home to Spring Boot  getEmpEnfo4");
		return "Welcome Home to Spring Boot  getEmpEnfo4";
	}

	@GetMapping(value = "/emp5")
	public String getEmpEnfo5() {

		simpleService.getEmpEnfo5();

		logger.info("Welcome Home to Spring Boot  getEmpEnfo5");
		return "Welcome Home to Spring Boot  getEmpEnfo5";
	}

	@GetMapping(value = "/empx")
	public ResponseEntity getEmpEnfoxx(@RequestParam(value = "del") Integer del) {
		String res = simpleService.getEmpEnfox(del);
		logger.info("getEmpEnfoxx: " + res);
		return ResponseEntity.status(200).body(res);
	}

	@GetMapping(value = "/")
	public String welcomeMsg() {
		logger.info("Welcome to SimpleWebApplication");
		return "Welcome to SimpleWebApplication";
	}

	@GetMapping(value = "/home")
	public String helloMsg() {

		simpleService.getEmpEnfo();

		logger.info("Welcome Home to Spring Boot  SimpleWebApplication");
		return "Welcome Home to Spring Boot  SimpleWebApplication";
	}

}
