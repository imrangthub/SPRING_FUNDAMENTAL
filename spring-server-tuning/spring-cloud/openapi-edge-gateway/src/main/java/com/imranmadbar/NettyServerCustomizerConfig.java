//package com.imranmadbar;
//
//import java.time.Duration;
//
//import org.springframework.boot.web.embedded.netty.NettyServerCustomizer;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class NettyServerCustomizerConfig {
//
//    @Bean
//    public NettyServerCustomizer nettyServerCustomizer() {
//        return httpServer -> httpServer.idleTimeout(Duration.ofMillis(1));
//    }
//
//}