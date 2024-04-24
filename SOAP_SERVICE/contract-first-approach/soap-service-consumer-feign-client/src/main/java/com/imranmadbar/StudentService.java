package com.imranmadbar;

import java.io.StringReader;
import java.io.StringWriter;

import org.springframework.stereotype.Service;

import com.imranmadbar.soapRequest.Body;
import com.imranmadbar.soapRequest.GetStudentDetailsRequest;
import com.imranmadbar.soapRequest.StudentSoapRequest;
import com.imranmadbar.soapResponse.GetStudentDetailsResponse;
import com.imranmadbar.soapResponse.StudentSoapResponse;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

@Service
public class StudentService {

	private final StudentFeignClient stClient;

	public StudentService(StudentFeignClient stClient) {
		this.stClient = stClient;
	}

	public GetStudentDetailsResponse getStudent() {
		

		GetStudentDetailsRequest stObj = new GetStudentDetailsRequest();
		stObj.setId(343434);
		
		Body bodyObj  = new Body();
		bodyObj.setGetStudentDetailsRequest(stObj);
		
		StudentSoapRequest request = new StudentSoapRequest();
		request.setBody(bodyObj);
		

		String soapRequestString = convertSoapRequestToXmlString(request);
		System.out.println("##############################Request: "+soapRequestString);
		String soapResponseString = stClient.doRequest(soapRequestString);
		System.out.println("##############################Response: "+soapResponseString);
		
		StudentSoapResponse res = convertSoapResponseFromString(soapResponseString);
		
		System.out.println("##############################getBody: "+res.getBody().getGetStudentDetailsResponse().getStudentDetails());

		return res.getBody().getGetStudentDetailsResponse();
	}

	private GetStudentDetailsResponse convartResponse(String responseString) {
		try {
			return convertXmlToObject(responseString, GetStudentDetailsResponse.class);
		} catch (JAXBException e) {
			throw new RuntimeException(e);
		}
	}

	private String convertSoapRequestToXmlString(Object request) {
		try {
			return convertObjectToXml(request);
		} catch (JAXBException e) {
			throw new RuntimeException(e);
		}
	}

	private StudentSoapResponse convertSoapResponseFromString(String responseString) {
		try {
			return convertXmlToObject(responseString, StudentSoapResponse.class);
		} catch (JAXBException e) {
			throw new RuntimeException(e);
		}
	}

	public static String convertObjectToXml(Object object) throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(object.getClass());
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

		StringWriter writer = new StringWriter();
		marshaller.marshal(object, writer);
		return writer.toString();
	}

	public static <T> T convertXmlToObject(String xml, Class<T> type) throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(type);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		return type.cast(unmarshaller.unmarshal(new StringReader(xml)));
	}

}