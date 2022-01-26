package com.imranmadbar.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.imranmadbar.spring_boot_soap_service.GetUserRequest;
import com.imranmadbar.spring_boot_soap_service.GetUserResponse;

@Endpoint
public class UserEndpoint {

	@Autowired
	private UserService userService;

	@ResponsePayload
	@PayloadRoot(namespace = "http://imranmadbar.com/spring-boot-soap-service", localPart = "getUserRequest")
	public GetUserResponse getUserRequest(@RequestPayload GetUserRequest request) {
		GetUserResponse response = new GetUserResponse();
		response.setUser(userService.getUsers(request.getName()));
		return response;
	}

}
