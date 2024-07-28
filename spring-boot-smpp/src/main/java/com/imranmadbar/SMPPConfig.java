package com.imranmadbar;


import java.io.IOException;

import org.jsmpp.bean.BindType;
import org.jsmpp.bean.NumberingPlanIndicator;
import org.jsmpp.bean.TypeOfNumber;
import org.jsmpp.extra.SessionState;
import org.jsmpp.session.BindParameter;
import org.jsmpp.session.SMPPSession;
import org.jsmpp.session.Session;
import org.jsmpp.session.SessionStateListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
@RequiredArgsConstructor
public class SMPPConfig {
	
	Logger logger = LoggerFactory.getLogger(SMPPConfig.class);
	
	public SMPPConfig(AppConfig appConfig ) {
		this.appConfig=appConfig;
	}

    private final AppConfig appConfig;

    @Bean
    public SMPPSession smppSession() {
        SMPPSession session = new SMPPSession();

        session.addSessionStateListener(new SessionStateListener() {
            @Override
            public void onStateChange(SessionState newState, SessionState oldState, Session source) {
            	logger.warn("Session State changed to " + newState);
            }
        });

        logger.info("Trying to connect SMSC......");
        session.setPduProcessorDegree(appConfig.getMAX_USERS());

        try {
            session.connectAndBind(
                    appConfig.getSMSC_IP(),
                    appConfig.getSMSC_PORT(),
                    new BindParameter(
                            BindType.BIND_TRX,
                            appConfig.getSYSTEM_ID(),
                            appConfig.getPASSWORD(),
                            appConfig.getCONSOLIDATION_ID(),
                            TypeOfNumber.UNKNOWN,
                            NumberingPlanIndicator.UNKNOWN,
                            null
                    )
            );
        } catch (IOException e) {
        	logger.error("SMSC Connection failed for " + e.getMessage());
        }

//        session.setTransactionTimer(60000);
        session.setEnquireLinkTimer(appConfig.getCONNECTION_WAITING_TIME());
        session.setQueueCapacity(appConfig.getQUEUE_CAPACITY());

        logger.info("SMSC session connected with IP: " + appConfig.getSMSC_IP()
                + " port: " + appConfig.getSMSC_PORT()
                + " users: " + appConfig.getMAX_USERS());
        return session;
    }
}

