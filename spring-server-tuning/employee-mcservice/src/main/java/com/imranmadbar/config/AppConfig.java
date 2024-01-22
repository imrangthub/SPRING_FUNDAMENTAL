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
//
//@Configuration
//public class AppConfig {
//	
//	@Autowired
//	ServerProperties serverProperties;
//	
//	@Bean
//	public TomcatConnectorCustomizer tomcatConnectorCustomizer() {
//    	serverProperties.getTomcat().setMaxConnections(1);
//       	serverProperties.getTomcat().setConnectionTimeout(Duration.ofMillis(1000));
//      	serverProperties.getTomcat().setAcceptCount(2);
//      	serverProperties.getTomcat().setKeepAliveTimeout(Duration.ofMillis(1000));
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
