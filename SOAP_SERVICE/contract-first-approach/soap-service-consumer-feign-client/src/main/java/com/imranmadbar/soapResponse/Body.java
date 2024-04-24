package com.imranmadbar.soapResponse;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Body {
	
	
	@XmlElement(name = "GetStudentDetailsResponse", namespace = "http://madbarsoft.com/students")
	private GetStudentDetailsResponse GetStudentDetailsResponse;

	public GetStudentDetailsResponse getGetStudentDetailsResponse() {
		return GetStudentDetailsResponse;
	}

	public void setGetStudentDetailsResponse(GetStudentDetailsResponse getStudentDetailsResponse) {
		GetStudentDetailsResponse = getStudentDetailsResponse;
	}



	


	
	

}
