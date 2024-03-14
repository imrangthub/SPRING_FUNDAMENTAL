package com.imranmadbar;

import org.springframework.boot.web.embedded.netty.NettyReactiveWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.stereotype.Component;

import io.netty.channel.ChannelOption;

@Component
public class MyNettyReactiveWebServerCustomizer implements WebServerFactoryCustomizer<NettyReactiveWebServerFactory> {

	@Override
	public void customize(NettyReactiveWebServerFactory factory) {
		factory.addServerCustomizers(builder -> builder.option(ChannelOption.SO_BACKLOG, 3000));
	}

}