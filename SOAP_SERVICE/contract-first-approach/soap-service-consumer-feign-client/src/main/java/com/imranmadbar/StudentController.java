package com.imranmadbar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imranmadbar.soapResponse.GetStudentDetailsResponse;
import com.imranmadbar.soapResponse.StudentDetails;


@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;

	@GetMapping(value = "/get-std")
	public StudentDetails getStudentDtl() {
		return studentService.getStudent().getStudentDetails();

	}

}
