package com.imranmadbar;

import java.io.IOException;

import org.jsmpp.bean.BindType;
import org.jsmpp.bean.NumberingPlanIndicator;
import org.jsmpp.bean.TypeOfNumber;
import org.jsmpp.session.BindParameter;
import org.jsmpp.session.SMPPSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class SMPPConnectionMonitor {

	private final SMPPSession session;
	private final AppConfig appConfig;

	Logger logger = LoggerFactory.getLogger(SMPPConnectionMonitor.class);

	@Autowired
	public SMPPConnectionMonitor(SMPPSession session, AppConfig appConfig) {
		this.session = session;
		this.appConfig = appConfig;
	}

	@Scheduled(fixedRate = 600)
	public void checkAndReconnect() {
		if (session != null && !session.getSessionState().isBound()) {
			logger.warn("Detected an unbound session, attempting to reconnect...");
			try {
				try {
					session.connectAndBind(appConfig.getSMSC_IP(), appConfig.getSMSC_PORT(),
							new BindParameter(BindType.BIND_TRX, appConfig.getSYSTEM_ID(), appConfig.getPASSWORD(),
									appConfig.getCONSOLIDATION_ID(), TypeOfNumber.UNKNOWN,
									NumberingPlanIndicator.UNKNOWN, null));
					logger.info("Reconnection successful.");
				} catch (IOException e) {
					logger.error("SMSC Connection failed for " + e.getMessage());
				}

			} catch (Exception e) {
				logger.error("Failed to reconnect the session: " + e.getMessage());
			}
		}
	}

}