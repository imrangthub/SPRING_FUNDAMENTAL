package com.imranmadbar.vsTs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.soap.SoapVersion;
import org.springframework.ws.soap.saaj.SaajSoapMessageFactory;

@Configuration
public class SoapConfiguration {

	private String connectContextPath = "com.imranmadbar.vsTs";

	private String connectUrl = "http://localhost:8080/imranmadbar/simple/item";

	@Bean
	public SimpleItemService connectClient() {

		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setContextPath(connectContextPath);

		SimpleItemService client = new SimpleItemService();
		client.setDefaultUri(connectUrl);
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		// client.setMessageFactory(messageFactory());

		return client;
	}

	@Bean
	public SimpleItemServiceTwo getSmSLangConnectionClient() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setContextPath(connectContextPath);
		SimpleItemServiceTwo client = new SimpleItemServiceTwo();
		client.setDefaultUri(connectUrl);
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);

		return client;
	}

	public SaajSoapMessageFactory messageFactory() {
		SaajSoapMessageFactory messageFactory = new SaajSoapMessageFactory();
		messageFactory.setSoapVersion(SoapVersion.SOAP_12);
		messageFactory.afterPropertiesSet();
		return messageFactory;
	}
}
