package com.imranmadbar;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public interface HomeFaing {

	@GetMapping(value = "/empf")
	ResponseEntity getEmpEnfo();

	@GetMapping(value = "/empf1")
	ResponseEntity getEmpEnfo1();

	@GetMapping(value = "/empf2")
	ResponseEntity getEmpEnfo2();

	@GetMapping(value = "/empf3")
	ResponseEntity getEmpEnfo3();

	@GetMapping(value = "/empfx")
	ResponseEntity getEmpEnfox(@RequestParam(value = "del") Integer del);


}
