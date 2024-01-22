package com.imranmadbar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HomeFaingController implements HomeFaing {

	Logger logger = LoggerFactory.getLogger(HomeFaingController.class);

	@Autowired
	private SimpleService simpleService;

	public ResponseEntity getEmpEnfo() {

		String res = simpleService.getEmpEnfo();
		logger.info("getEmpEnfoFaingRes: " + res);
		return ResponseEntity.status(200).body(res);
	}

	public ResponseEntity getEmpEnfo1() {

		String res = simpleService.getEmpEnfo1();
		logger.info("getEmpEnfo1: " + res);
		return ResponseEntity.status(200).body(res);
	}

	public ResponseEntity getEmpEnfo2() {

		String res = simpleService.getEmpEnfo2();
		logger.info("getEmpEnfo2: " + res);
		return ResponseEntity.status(200).body(res);
	}

	public ResponseEntity getEmpEnfo3() {
		String res = simpleService.getEmpEnfo3();
		logger.info("getEmpEnfo3: " + res);
		return ResponseEntity.status(200).body(res);
	}

	public ResponseEntity getEmpEnfox(Integer sleepData) {
		String res = simpleService.getEmpEnfox(sleepData);
		logger.info("getEmpEnfo3: " + res);
		return ResponseEntity.status(200).body(res);
	}

}
