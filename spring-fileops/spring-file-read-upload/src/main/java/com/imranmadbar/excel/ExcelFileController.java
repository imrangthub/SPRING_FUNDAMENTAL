package com.imranmadbar.excel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imranmadbar.Course;
import com.imranmadbar.Employee;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ResponseBody;


@RestController
@RequiredArgsConstructor
@RequestMapping("/excel")
public class ExcelFileController {
	
	private static final Logger logger = LoggerFactory.getLogger(ExcelFileController.class);

	@Autowired
	private  ExcelFileService excelFileService;


	@GetMapping("/write")
	public void generateExcelReport(HttpServletResponse response) throws Exception {

		response.setContentType("application/octet-stream");

		// Excel file will be generated and saved to C:\Users\admin\Downloads as 'employee.xls'

		String headerKey = "Content-Disposition";
		String headerValue = "attachment;filename=employees.xls";
// OR String headerValue = "attachment;filename=employees.xlsx";

		response.setHeader(headerKey, headerValue);

		logger.info("Generate an Excel file");
		excelFileService.generateExcel(response);

		response.flushBuffer();
	}

	
	@GetMapping("/read")
	public @ResponseBody List<Course> readCSV2() {
		logger.info("Read courses in Excel file and return courses in JSON format");
		return excelFileService.readExcelFileTwo();
	}
	
	

}
