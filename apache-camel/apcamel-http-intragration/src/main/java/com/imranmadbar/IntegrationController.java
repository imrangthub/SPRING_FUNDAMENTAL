package com.imranmadbar;

import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IntegrationController {

	@Autowired
	private ProducerTemplate producerTemplate;

	@GetMapping("/start-integration")
	public String startIntegration() {
		// Trigger the Camel route
		return producerTemplate.requestBody("direct:startIntegration", null, String.class);
	}

}
