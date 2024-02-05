package com.imranmadbar.fing;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeingController {

	Logger logger = LoggerFactory.getLogger(FeingController.class);

	@Autowired
	private FeingService reingService;

	@GetMapping(value = "/fes")
	public ResponseEntity getEmpEnfo() {
		String res = reingService.getEmpEnfo();
		logger.info("getEmpEnfoFes: " + res);
		return ResponseEntity.status(200).body(res);
	}

	@GetMapping(value = "/fes1")
	public ResponseEntity getEmpEnfo1() {
		String res = reingService.getEmpEnfo1();
		logger.info("getEmpEnfo1Fes1: " + res);
		return ResponseEntity.status(200).body(res);
	}

}
