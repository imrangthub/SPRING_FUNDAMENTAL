package com.imranmadbar;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;

import reactor.core.publisher.Mono;

@Component
public class RequestIntercept implements WebFilter, Ordered {
	
	@Override
	public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
		
		
		// Get the headers from the request
		Map<String, List<String>> headers = exchange.getRequest().getHeaders();

	    System.out.println("------------------- header start ------------------");
		for (Map.Entry<String, List<String>> entry : headers.entrySet()) {
		    String headerName = entry.getKey();
		    List<String> headerValues = entry.getValue();

		    System.out.println(headerName + ": " + String.join(", ", headerValues));
		}
		
	    System.out.println("------------------- header end ------------------");
		return chain.filter(exchange);
	}

	@Override
	public int getOrder() {
		return 1;
	}

}