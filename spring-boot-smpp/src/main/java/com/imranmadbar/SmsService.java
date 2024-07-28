package com.imranmadbar;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SmsService {

	private final SmppIntegration smppIntegration;

	public SmsService(SmppIntegration smppIntegration) {
		this.smppIntegration = smppIntegration;
	}

	public SmsSendStatus sendSms(SMSRequest request) {
		return smppIntegration.sendSms(request);

	}

}
