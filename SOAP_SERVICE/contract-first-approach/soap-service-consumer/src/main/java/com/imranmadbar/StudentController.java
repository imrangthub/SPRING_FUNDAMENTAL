package com.imranmadbar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imranmadbar.soap.GetStudentDetailsResponse;


@RestController
public class StudentController {

	@Autowired
	private StudentClient studentClient;

	@GetMapping(value = "/get-stdtl")
	public String getStudentDtl() {
		GetStudentDetailsResponse res = studentClient.getStudent();
		return res.getStudentDetails().getName();

	}

}
