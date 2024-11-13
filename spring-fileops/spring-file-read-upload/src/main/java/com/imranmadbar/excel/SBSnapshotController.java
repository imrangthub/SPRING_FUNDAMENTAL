package com.imranmadbar.excel;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("/sb-snapshot")
public class SBSnapshotController {
	
	
	@Autowired
	private SBSnapshotService sbSnapshotService;

	@PostMapping(value = { "/upload" }, consumes = { "multipart/form-data" })
	public ResponseEntity<?> importExcelFile(MultipartFile myExcelFile) {
		try {
			String fileUpRes = sbSnapshotService.readExcel(myExcelFile);
			
			return ResponseEntity.ok(fileUpRes);
		} catch (IOException var3) {
			return ResponseEntity.status(500).build();
		}
	}

}
