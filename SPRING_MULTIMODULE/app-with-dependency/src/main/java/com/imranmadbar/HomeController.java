package com.imranmadbar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.imranmadbar.core.CoreCommonFunction;
import com.imranmadbar.shared.SharedTestClas;

@RestController
public class HomeController implements CoreCommonFunction, SharedTestClas {

	Logger logger = LoggerFactory.getLogger(HomeController.class);

	@GetMapping(value = "/2")
	public String welcomeMsg2() {
		return getBothMsg();
	}
	
	@GetMapping(value = "/")
	public String welcomeMsg() {
		return getSimpleMsg();
	}

	@GetMapping(value = "/home")
	public String helloMsg() {
		logger.info("Welcome Home to Spring Boot  SimpleWebApplication");
		return "Welcome Home to Spring Boot  SimpleWebApplication";
	}

}
