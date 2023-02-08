package com.imran.moduleservicetwo;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class AppConfig {

	@Bean
	public WebClient localApiClient() {
		return WebClient.create("https://reqres.in/api");
	}

}
