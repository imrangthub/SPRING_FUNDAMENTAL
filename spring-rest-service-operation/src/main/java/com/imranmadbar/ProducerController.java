package com.imranmadbar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="producer",produces = "text/html;charset=UTF-8")
public class ProducerController {
	
	Logger logger = LoggerFactory.getLogger(ProducerController.class);

	@GetMapping("/bgn1")
	public String bgn1() {
		return "à¦®à§à¦¬à¦¾à¦à¦²à§ à¦¬à¦¾à¦à¦²à¦¾ à¦²à¦¿à¦à¦¨";
	}
	
	@GetMapping("/bgn0")
	public String index() {
		return "আমাদের গ্ৰাম - বাংলা";
	}
	
	
	
	
	
}
