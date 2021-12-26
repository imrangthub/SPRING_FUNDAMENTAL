package com.imranmadbar;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	 @GetMapping("/")
	  public String getHomeMsg() {
	    return "Welcome to bean scope application";
	  }

} 
