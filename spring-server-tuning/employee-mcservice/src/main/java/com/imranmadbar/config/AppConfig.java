//package com.imranmadbar.config;
//
//import java.time.Duration;
//
//import org.apache.catalina.connector.Connector;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.web.ServerProperties;
//import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
//import org.springframework.web.client.RestTemplate;
//
//@Configuration
//public class AppConfig {
//	
//	@Autowired
//	ServerProperties serverProperties;
//	
//	
//	 
//	
//	@Bean
//	public TomcatConnectorCustomizer tomcatConnectorCustomizer() {
//    	serverProperties.getTomcat().setMaxConnections(1);
//       	serverProperties.getTomcat().setConnectionTimeout(Duration.ofMillis(10));
//      	serverProperties.getTomcat().setAcceptCount(2);
//      	serverProperties.getTomcat().setKeepAliveTimeout(Duration.ofMillis(10));
//      	
//		return connector -> {
//			if (connector instanceof Connector) {
////                ((Connector) connector).setAttribute("connectionTimeout", 1000); // Set connection timeout in milliseconds
//
//			}
//		};
//	}
//
//}
