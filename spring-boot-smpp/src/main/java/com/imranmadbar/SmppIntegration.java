package com.imranmadbar;

import java.io.IOException;

import org.jsmpp.InvalidResponseException;
import org.jsmpp.PDUException;
import org.jsmpp.bean.Alphabet;
import org.jsmpp.bean.ESMClass;
import org.jsmpp.bean.GeneralDataCoding;
import org.jsmpp.bean.MessageClass;
import org.jsmpp.bean.NumberingPlanIndicator;
import org.jsmpp.bean.OptionalParameter;
import org.jsmpp.bean.RegisteredDelivery;
import org.jsmpp.bean.SMSCDeliveryReceipt;
import org.jsmpp.bean.TypeOfNumber;
import org.jsmpp.extra.NegativeResponseException;
import org.jsmpp.extra.ResponseTimeoutException;
import org.jsmpp.session.SMPPSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;



@Service
public class SmppIntegration {
	
	
	Logger logger = LoggerFactory.getLogger(SmppIntegration.class);

    @Autowired
    private SMPPSession smppSession;

    public SmsSendStatus sendSms(SMSRequest request){
        String messageId = null;
        try {
            byte[] textBytes = request.getText().getBytes("UTF-16BE");
            OptionalParameter messagePayload = new OptionalParameter.OctetString(
                    OptionalParameter.Tag.MESSAGE_PAYLOAD.code(), textBytes);
            messageId = String.valueOf(smppSession.submitShortMessage(
                    "CMT",
                    TypeOfNumber.UNKNOWN,
                    NumberingPlanIndicator.UNKNOWN,
                    request.getMask(),
                    TypeOfNumber.INTERNATIONAL,
                    NumberingPlanIndicator.UNKNOWN,
                    request.getMobileNumber(),
                    new ESMClass(),
                    (byte)0,
                    (byte)1,
                    null,
                    null,
                    new RegisteredDelivery(SMSCDeliveryReceipt.DEFAULT),
                    (byte)0,
                    new GeneralDataCoding( Alphabet.ALPHA_UCS2, MessageClass.CLASS1),
                    (byte)0,
                    new byte[0], messagePayload));

            logger.info("SMS acknowledgement sent successfully to SMSC for  " + request);
            return SmsSendStatus.success( messageId );

        } catch (PDUException | InvalidResponseException | ResponseTimeoutException | NegativeResponseException |
                 IOException e) {

            messageId = e.getMessage();
            logger.error(messageId + " for number: " + request.getMobileNumber());
            return SmsSendStatus.failed( HttpStatus.BAD_REQUEST.value(), messageId );

        } catch (Exception e){

            messageId = e.getMessage();
            logger.error(messageId);
            return SmsSendStatus.failed( HttpStatus.INTERNAL_SERVER_ERROR.value(), messageId );

        }

    }

}
