package com.imranmadbar.vsTs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleItemController {

	@Autowired
	private SimpleItemServiceTwo csLangService;

	@Autowired
	private SimpleItemService simpleItemService;

	@PostMapping("/getItemLang")
	public ResponseEntity<List<Item>> getItemLang(@RequestBody SimpleItemServiceRequest serviceRequest) {
		return ResponseEntity.ok(csLangService.getItemLang(serviceRequest));
	}

	@PostMapping("/getSimpleItem")
	public ResponseEntity<List<Item>> getSimpleItem(@RequestBody SimpleItemServiceRequest serviceRequest) {
		return ResponseEntity.ok(simpleItemService.getSimpleItem(serviceRequest));
	}

	@PostMapping("/findSimpleItem")
	public ResponseEntity<List<Item>> findSimpleItem(@RequestBody SimpleItemServiceRequest serviceRequest) {
		return ResponseEntity.ok(simpleItemService.findSimpleItem(serviceRequest));
	}

}
