//package com.imranmadbar;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.http.client.reactive.ClientHttpConnector;
//import org.springframework.http.client.reactive.ReactorClientHttpConnector;
//
//import reactor.netty.http.client.HttpClient;
//import reactor.netty.resources.ConnectionProvider;
//
//@Configuration
//public class AppConfig2 {
//
//	@Bean
//	@Primary
//	public ClientHttpConnector clientHttpConnector() {
//		return new ReactorClientHttpConnector(HttpClient.create(ConnectionProvider.newConnection()));
//	}
//
//}
