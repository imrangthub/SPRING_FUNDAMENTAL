package com.imranmadbar.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

import com.imranmadbar.soap.bindings.ItemRequest;
import com.imranmadbar.soap.bindings.ItemResponse;

@Service
public class SoapClient {

	@Autowired
	private Jaxb2Marshaller jaxb2Marshaller;

	private WebServiceTemplate webServiceTemplate;

	public ItemResponse getItemInfo(ItemRequest itemRequest) {
		webServiceTemplate = new WebServiceTemplate(jaxb2Marshaller);
		return (ItemResponse) webServiceTemplate.marshalSendAndReceive("http://localhost:8080/imranmadbar-url", itemRequest);
	}
}