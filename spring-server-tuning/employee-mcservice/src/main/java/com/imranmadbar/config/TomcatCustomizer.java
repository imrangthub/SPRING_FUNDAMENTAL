package com.imranmadbar.config;

import org.apache.coyote.http11.AbstractHttp11Protocol;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

//	@Bean
//	public ConfigurableServletWebServerFactory webServerFactory() {
//	  TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
//	  factory.addConnectorCustomizers(
//	      connector -> {
//	        Http11NioProtocol protocol =
//	            (Http11NioProtocol) connector.getProtocolHandler();
//	        protocol.setConnectionTimeout(1);
////	        protocol.setDisableUploadTimeout(false);
//	      }
//	  );
//	  return factory;
//	}
//	

	@Primary
	@Override
	public void customize(TomcatServletWebServerFactory factory) {
		factory.addConnectorCustomizers(connector -> {
			AbstractHttp11Protocol protocol = (AbstractHttp11Protocol) connector.getProtocolHandler();

//            protocol.setMaxKeepAliveRequests(10);

			// protocol.setMaxKeepAliveRequests(1);

//			protocol.setMaxConnections(1);
//			protocol.setConnectionTimeout(1);
			// protocol.setKeepAliveTimeout(1);

			System.out.println("server##################: " + protocol.getServer());

//            protocol.setMaxKeepAliveRequests(1);
//            protocol.setMaxConnections(1);
			// protocol.setConnectionTimeout(1);
//            protocol.setKeepAliveTimeout(1);

			log.info("####################################################################################");
			log.info("#");
			log.info("# TomcatCustomizer");
			log.info("#");
			log.info("# custom maxKeepAliveRequests {}", protocol.getMaxKeepAliveRequests());
			log.info("# keepalive timeout: {} ms", protocol.getKeepAliveTimeout());
			log.info("# connection timeout: {} ms", protocol.getConnectionTimeout());
			log.info("# max connections: {}", protocol.getMaxConnections());
			log.info("# max getMaxThreads: {}", protocol.getMaxThreads());
			log.info("#");
			log.info("####################################################################################");

		});
	}
}

//
//@Async("asyncExec")
//@PostMapping("/delayedService")
//public CompletableFuture<String> doDelay()
//{ 
//    String response = service.callDelayedService();
//    return CompletableFuture.completedFuture(response);
//}
//
//
//
//
//
//@Bean(name="asyncExec")
//public Executor asyncExecutor()
//{
//    ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
//    executor.setCorePoolSize(3);
//    executor.setMaxPoolSize(3);
//    executor.setQueueCapacity(10);
//    executor.setThreadNamePrefix("AsynchThread-");
//    executor.setAllowCoreThreadTimeOut(true);
//    executor.setKeepAliveSeconds(10);
//    executor.initialize();
//
//    return executor;
//}
