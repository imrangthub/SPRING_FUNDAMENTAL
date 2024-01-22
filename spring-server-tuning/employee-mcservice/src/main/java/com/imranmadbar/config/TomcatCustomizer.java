package com.imranmadbar.config;

import org.apache.coyote.http11.AbstractHttp11Protocol;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.imranmadbar.HomeController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class TomcatCustomizer implements WebServerFactoryCustomizer<TomcatServletWebServerFactory> {
	
	Logger log = LoggerFactory.getLogger(HomeController.class);

	@Primary
    @Override
    public void customize(TomcatServletWebServerFactory factory) {
        factory.addConnectorCustomizers(connector -> {
            AbstractHttp11Protocol protocol = (AbstractHttp11Protocol) connector.getProtocolHandler();

//            protocol.setMaxKeepAliveRequests(10);
           
            protocol.setMaxKeepAliveRequests(2);
            protocol.setMaxConnections(2);
            protocol.setConnectionTimeout(10);
            protocol.setKeepAliveTimeout(10);
            log.info("####################################################################################");
            log.info("#");
            log.info("# TomcatCustomizer");
            log.info("#");
            log.info("# custom maxKeepAliveRequests {}", protocol.getMaxKeepAliveRequests());
            log.info("# keepalive timeout: {} ms", protocol.getKeepAliveTimeout());
            log.info("# connection timeout: {} ms", protocol.getConnectionTimeout());
            log.info("# max connections: {}", protocol.getMaxConnections());
            log.info("#");
            log.info(
                "####################################################################################");
         

        });
    }
}