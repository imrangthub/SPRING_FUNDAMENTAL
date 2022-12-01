package com.imranmadbar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imranmadbar.core.CoreCommonFunction;
import com.imranmadbar.shared.SharedTestClas;
import com.imranmadbar.shared2.AppSharedWithSPBoot;
import com.imranmadbar.shared2.SharedTwo;

@RestController
public class HomeController implements CoreCommonFunction, SharedTestClas, SharedTwo {

	Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	
	@Autowired
	public AppSharedWithSPBoot appSharedWithSPBoot;
	
	
	@GetMapping(value = "/4")
	public String getMsg4() {
		return appSharedWithSPBoot.getMsgFromShared2Services();
	}


	@GetMapping(value = "/3")
	public String getMsg3() {
		return getSharedTwoMsg();
	}

	@GetMapping(value = "/2")
	public String getMsg2() {
		return getBothMsg();
	}

	@GetMapping(value = "/1")
	public String getMsg1() {
		return getSimpleMsg();
	}

	@GetMapping(value = "/home")
	public String helloMsg() {
		logger.info("Welcome Home to Spring Boot  SimpleWebApplication");
		return "Welcome Home to Spring Boot  SimpleWebApplication";
	}

}
