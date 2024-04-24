package com.imranmadbar.soapRequest;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Body {
	
	
	@XmlElement(name = "GetStudentDetailsRequest", namespace = "http://madbarsoft.com/students")
	private GetStudentDetailsRequest GetStudentDetailsRequest;

	public GetStudentDetailsRequest getGetStudentDetailsRequest() {
		return GetStudentDetailsRequest;
	}

	public void setGetStudentDetailsRequest(GetStudentDetailsRequest getStudentDetailsRequest) {
		GetStudentDetailsRequest = getStudentDetailsRequest;
	}


	
	

}
