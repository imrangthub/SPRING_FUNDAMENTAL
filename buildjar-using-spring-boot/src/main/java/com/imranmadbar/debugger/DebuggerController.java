package com.imranmadbar.debugger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DebuggerController {

	Logger logger = LoggerFactory.getLogger(DebuggerController.class);
	
	
	

	@GetMapping(value = "/debug1")
	public String welcomeMsg() {
		logger.info("Welcome to DebuggerController");
		return "Welcome to DebuggerController";
	}

	@GetMapping(value = "/debug2")
	public String helloMsg() {
		logger.info("Welcome Home to Spring Boot  DebuggerController");
		return "Welcome Home to Spring Boot  DebuggerController";
	}

}
