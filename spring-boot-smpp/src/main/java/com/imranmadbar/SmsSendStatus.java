package com.imranmadbar;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Getter
@Setter
@ToString
@Accessors(chain = true)
public class SmsSendStatus {

	private int code;

	private boolean smsDeliveryStatus;

	private String message;

	public static SmsSendStatus success(String messageId) {
		return new SmsSendStatus().setCode(HttpStatus.OK.value()).setSmsDeliveryStatus(true)
				.setMessage("SMS sent successfully to SMSC with Message ID: " + messageId);
	}

	public static SmsSendStatus failed(int code, String errMessage) {
		return new SmsSendStatus().setCode(code).setSmsDeliveryStatus(false).setMessage(errMessage);
	}

}
