package com.imranmadbar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeingController {

	Logger logger = LoggerFactory.getLogger(FeingController.class);

	@Autowired
	private FeingService reingService;
	
	
	@GetMapping(value = "/bsvc0")
	public ResponseEntity<String> getEmpEnfox() {
	
		
		return ResponseEntity.ok(reingService.getEmpEnfo0());
	}
	
	
	
//	@GetMapping(value = "/bsvc0")
//	public ResponseEntity getEmpEnfox() {
//		ResponseEntity res = reingService.getEmpEnfo0();
//		logger.info("getEmpEnfo1Fes1: " + res);
//		return res;
//	}

	@GetMapping(value = "/bsvc1")
	public ResponseEntity getEmpEnfo() {
		String res = reingService.getEmpEnfo();
		logger.info("getEmpEnfoFes: " + res);
		return ResponseEntity.status(200).body(res);
	}

	@GetMapping(value = "/bsvc1/delay200")
	public ResponseEntity getEmpEnfo1() {
		String res = reingService.getEmpEnfo1();
		logger.info("getEmpEnfo1Fes1: " + res);
		return ResponseEntity.status(200).body(res);
	}

	@GetMapping(value = "/bsvc1/delay2000")
	public ResponseEntity getEmpEnfo2() {
		String res = reingService.getEmpEnfo2();
		logger.info("getEmpEnfo1Fes2: " + res);
		return ResponseEntity.status(200).body(res);
	}

	@GetMapping(value = "/bsvc1/delay3000")
	public ResponseEntity getEmpEnfo3() {
		String res = reingService.getEmpEnfo3();
		logger.info("getEmpEnfo1Fes3: " + res);
		return ResponseEntity.status(200).body(res);
	}

	@GetMapping(value = "/bsvc1/delay4000")
	public ResponseEntity getEmpEnfo4() {
		String res = reingService.getEmpEnfo4();
		logger.info("getEmpEnfo1Fes4: " + res);
		return ResponseEntity.status(200).body(res);
	}

	@GetMapping(value = "/bsvc1/delay5000")
	public ResponseEntity getEmpEnfo5() {
		String res = reingService.getEmpEnfo5();
		logger.info("getEmpEnfo1Fes5: " + res);
		return ResponseEntity.status(200).body(res);
	}

	@GetMapping(value = "/bsvc1/delayx")
	public ResponseEntity getEmpEnfox(@RequestParam(value = "del", required = false) Integer del) {
		ResponseEntity res = reingService.getEmpEnfox(del);
		logger.info("getEmpEnfo1Fes1: " + res);
		return res;
	}

	@GetMapping(value = "/bsvc1/delayx2")
	public ResponseEntity getEmpEnfoxn(@RequestParam(value = "del", required = false) Integer del) {
		ResponseEntity res = reingService.getEmpEnfoxn(del);
		logger.info("getEmpEnfo1Fes1: " + res);
		return res;
	}

}
