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
	
	
	
	@GetMapping(value = "/intsc0")
	public ResponseEntity intsc0() {
		String res = simpleService.getEmpEnfox(200);
		logger.info("getEmpEnfox: " + res);
		return ResponseEntity.status(200).body(res);
	}

	
	

	@GetMapping(value = "/intsc1")
	public String getEmpEnfo() {
		String res = simpleService.getEmpEnfo();
		logger.info(res);
		return res;
	}

	@GetMapping(value = "/intsc1/delay200")
	public String getEmpEnfo1() {
		String res = simpleService.getEmpEnfo1();
		logger.info(res);
		return res;
	}

	@GetMapping(value = "/intsc1/delay2000")
	public String getEmpEnfo2() {
		String res = simpleService.getEmpEnfo2();
		logger.info(res);
		return res;
	}

	@GetMapping(value = "/intsc1/delay3000")
	public String getEmpEnfo3() {
		String res = simpleService.getEmpEnfo3();
		logger.info(res);
		return res;
	}

	@GetMapping(value = "/intsc1/delay4000")
	public String getEmpEnfo4() {
		String res = simpleService.getEmpEnfo4();
		logger.info(res);
		return res;
	}

	@GetMapping(value = "/intsc1/delay5000")
	public String getEmpEnfo5() {
		String res = simpleService.getEmpEnfo5();
		logger.info(res);
		return res;
	}

	@GetMapping(value = "/intsc1/delayx")
	public ResponseEntity getEmpEnfox(@RequestParam(value = "del", required = false) Integer del) {
		String res = simpleService.getEmpEnfox(del);
		logger.info("getEmpEnfox: " + res);
		return ResponseEntity.status(200).body(res);
	}

	
	
	@GetMapping(value = "/intsc1/delayx2")
	public ResponseEntity getEmpEnfoxn(@RequestParam(value = "del", required = false) Integer del) {
		int sleeptime = 100;

		if (del > 0) {
			sleeptime = del;
		}
		try {
			Thread.sleep(sleeptime);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	
	
	@GetMapping(value = "/home")
	public String home() {
		logger.info("Welcome to IntegrationSvcApplication Home");
		return "Welcome to IntegrationSvcApplication Home";
	}
	
	
	@GetMapping(value = "/")
	public String welcomeMsg() {
		logger.info("Welcome to IntegrationSvcApplication");
		return "Welcome to IntegrationSvcApplication";
	}
	
	
	
	@GetMapping(value = "/exc1")
	public String excep1() {
		logger.info("Throw RuntimeException1");
		simpleService.thExcept1();
		return "Throw RuntimeException1";
	}

}
