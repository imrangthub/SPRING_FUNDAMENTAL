package com.imranmadbar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@Service
public class WebClientService {
	

	Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	WebClient webClient = WebClient.create("http://localhost:8181");
	


	public String getEmpEnfo() {
		return "Hellow From getEmpEnfo";
	}

	public String getEmpwebClient() {
		logger.info("###############Make Request:");
		String responseJson = webClient.get()
	            .uri("/emp3")
	            .retrieve()
	            .bodyToMono(String.class)
	            .block();
		
		logger.info("############Got Response:"+responseJson);
		return responseJson;
		
	}
	
	public Mono<String> getEmployeewebClient2() {
	    return webClient.get()
	            .uri("/emp3")
	            .retrieve()
	            .bodyToMono(String.class).log();
	}
	
	public Mono<String> getEmpWebClient3() {
	    // Log request initiation
	    logger.info("###############Make Request:");

	    // Perform the WebClient request and return a Mono<String>
	    return webClient.get()
	            .uri("/emp3")
	            .retrieve()
	            .bodyToMono(String.class)
	            .doOnNext(responseJson -> {
	                // Log the received response
	                logger.info("############Got Response: {}", responseJson);
	            })
	            .doFinally(signalType -> {
	                // Log the completion of the operation
	                logger.info("############### getEmpWebClient3 Execution Done !");
	            });
	}
	
	
	

	

	public String getEmpEnfox(int sleepData) {

		int sleeptime = 100;

		if (sleepData > 0) {
			sleeptime = sleepData;
		}

		try {
			Thread.sleep(sleeptime);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "Hellow From getEmpEnfo1";
	}

}
