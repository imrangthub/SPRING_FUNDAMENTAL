package com.imranmadbar;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.madbarsoft.students.GetStudentDetailsRequest;
import com.madbarsoft.students.GetStudentDetailsResponse;
import com.madbarsoft.students.GetStudentRequest;
import com.madbarsoft.students.StudentDetails;

@Endpoint
public class StudentAppEndpoint {

	@PayloadRoot(namespace = "http://madbarsoft.com/students", localPart = "GetStudentRequest")
	@ResponsePayload
	public GetStudentDetailsResponse getStudent(@RequestPayload GetStudentRequest request) {

		GetStudentDetailsResponse response = new GetStudentDetailsResponse();

		StudentDetails studentDetails = new StudentDetails();
		studentDetails.setName("MD IMRAN HOSSAIN");
		response.setStudentDetails(studentDetails);

		return response;
	}

	@PayloadRoot(namespace = "http://madbarsoft.com/students", localPart = "GetStudentDetailsRequest")
	@ResponsePayload
	public GetStudentDetailsResponse processCourseDetailsRequest(@RequestPayload GetStudentDetailsRequest request) {

		GetStudentDetailsResponse response = new GetStudentDetailsResponse();

		StudentDetails studentDetails = new StudentDetails();
		studentDetails.setId(request.getId());
		studentDetails.setName("MD IMRAN HOSSAIN Update");
		studentDetails.setPassportNumber("PS4354M");

		response.setStudentDetails(studentDetails);

		return response;
	}

}