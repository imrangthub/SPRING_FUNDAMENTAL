package com.imranmadbar.vsTs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VasController {

	@Autowired
	private CsLangService csLangService;
	
	@Autowired
	private VasService vasService;
	
	@PostMapping("/getSMSLang")
	public ResponseEntity<List<Item>> getSMSLang(@RequestBody VasServiceRequest vasServiceRequest) {
		return ResponseEntity.ok(csLangService.getSMSLang(vasServiceRequest));
	}

	@PostMapping("/allowVasServices")
	public ResponseEntity<List<Item>> allowVasServices(@RequestBody VasServiceRequest vasServiceRequest) {
		return ResponseEntity.ok(vasService.allowVasServices(vasServiceRequest));
	}

	@PostMapping("/stopAllVasServices")
	public ResponseEntity<List<Item>> stopAllVasServices(@RequestBody VasServiceRequest vasServiceRequest) {
		return ResponseEntity.ok(vasService.stopAllVasServices(vasServiceRequest));
	}

}
