package com.imranmadbar.endpoint;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.imranmadbar.soap.bindings.ItemRequest;
import com.imranmadbar.soap.bindings.ItemResponse;
import com.imranmadbar.soap.bindings.ObjectFactory;



@Endpoint
public class WebServiceEndpoint {
	
	@ResponsePayload
	@PayloadRoot(namespace = "http://imranmadbar.com", localPart = "ItemRequest")
	public ItemResponse helloMsg(@RequestPayload ItemRequest request) {

		String outputString = "Hello " + request.getName();
		ObjectFactory factory = new ObjectFactory();
		ItemResponse response = factory.createItemResponse();
		response.setResult(outputString);
		
		return response;
	}
	
	
	@ResponsePayload
	@PayloadRoot(namespace = "http://imranmadbar.com", localPart = "ItemRequest2")
	public ItemResponse hiMsg(@RequestPayload ItemRequest request) {

		String outputString = "Hi " + request.getName();
		ObjectFactory factory = new ObjectFactory();
		ItemResponse response = factory.createItemResponse();
		response.setResult(outputString);
		
		return response;
	}

	
	
	
	
	
	
	
}


