package com.imranmadbar;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import com.imranmadbar.soap.GetStudentDetailsRequest;
import com.imranmadbar.soap.GetStudentDetailsResponse;


public class StudentClient extends WebServiceGatewaySupport {

	public GetStudentDetailsResponse getStudent() {
		GetStudentDetailsRequest request = new GetStudentDetailsRequest();
		request.setId(1);
		GetStudentDetailsResponse response = (GetStudentDetailsResponse) getWebServiceTemplate()
				.marshalSendAndReceive(request);
		return response;

	}
}
