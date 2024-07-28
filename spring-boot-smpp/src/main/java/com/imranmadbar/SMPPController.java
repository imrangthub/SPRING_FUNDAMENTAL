package com.imranmadbar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/sms", produces = MediaType.APPLICATION_JSON_VALUE)
public class SMPPController {

	@Autowired
	private SmsService service;

	@PostMapping("/send")
	public SmsSendStatus sendSMS(@Validated @RequestBody SMSRequest request) {
		return service.sendSms(request);
	}

}