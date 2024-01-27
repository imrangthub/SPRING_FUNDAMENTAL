package com.imranmadbar;

import java.time.Duration;

import org.springframework.cloud.gateway.config.HttpClientProperties;
import org.springframework.cloud.gateway.config.HttpClientProperties.Pool.PoolType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import io.netty.channel.ChannelHandlerContext;
import reactor.netty.channel.ChannelOperations;


@Configuration
public class AppConfig {
	
	
	
//    @Bean
//    @Primary
//    public HttpClientProperties overwrittenHttpClientProperties() {
//        HttpClientProperties p = new HttpClientProperties();
//        
//        p.getPool().setType(PoolType.FIXED);
//        p.getPool().setMaxConnections(2);
//        p.getPool().setMaxIdleTime(Duration.ofMillis(5));
//        p.getPool().setMaxLifeTime(Duration.ofMillis(5));
//
//
////        p.setConnectTimeout(40000);
////        p.setResponseTimeout(Duration.ofMillis(4000));
//        
//        
//        return p;
//    }
//    

	
	
	
	
	
	
//    @Bean
//    @Primary
//    public HttpClientProperties overwrittenHttpClientProperties() {
//        HttpClientProperties p = new HttpClientProperties();
//        p.setConnectTimeout(300);
//        p.setResponseTimeout(Duration.ofMillis(1000));
//        return p;
//    }

}
