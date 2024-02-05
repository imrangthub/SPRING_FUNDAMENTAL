package com.imranmadbar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private SimpleService simpleService;

	@GetMapping(value = "/intsc")
	public String getEmpEnfo() {
		String res = simpleService.getEmpEnfo();
		logger.info(res);
		return res;
	}

	@GetMapping(value = "/intsc1")
	public String getEmpEnfo1() {
		String res = simpleService.getEmpEnfo1();
		logger.info(res);
		return res;
	}

	@GetMapping(value = "/intsc2")
	public String getEmpEnfo2() {
		String res = simpleService.getEmpEnfo2();
		logger.info(res);
		return res;
	}

	@GetMapping(value = "/intsc3")
	public String getEmpEnfo3() {
		String res = simpleService.getEmpEnfo3();
		logger.info(res);
		return res;
	}

	@GetMapping(value = "/intsc4")
	public String getEmpEnfo4() {
		String res = simpleService.getEmpEnfo4();
		logger.info(res);
		return res;
	}

	@GetMapping(value = "/intsc5")
	public String getEmpEnfo5() {
		String res = simpleService.getEmpEnfo5();
		logger.info(res);
		return res;
	}

	@GetMapping(value = "/intscx")
	public ResponseEntity getEmpEnfoxx(@RequestParam(value = "del", required = false) Integer del) {
		String res = simpleService.getEmpEnfox(del);
		logger.info("getEmpEnfox: " + res);
		return ResponseEntity.status(200).body(res);
	}

	@GetMapping(value = "/")
	public String welcomeMsg() {
		logger.info("Welcome to IntegrationSvcApplication");
		return "Welcome to IntegrationSvcApplication";
	}



}
