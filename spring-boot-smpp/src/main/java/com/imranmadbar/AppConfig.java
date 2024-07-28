package com.imranmadbar;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

	@Value("${smpp.smsc.ip}")
	private String SMSC_IP;

	@Value("${smpp.smsc.port}")
	private int SMSC_PORT;

	@Value("${smpp.smsc.system.id}")
	private String SYSTEM_ID;

	@Value("${smpp.smsc.password}")
	private String PASSWORD;

	@Value("${smpp.smsc.consolidation.id}")
	private String CONSOLIDATION_ID;

	@Value("${smpp.smsc.queue.capacity}")
	private Integer QUEUE_CAPACITY;

	@Value("${smpp.smsc.connection.waiting.time}")
	private Integer CONNECTION_WAITING_TIME;

	private final int LEVEL_THROUGHPUT = 120;
	private final int INPUT_WINDOW = 120;
	private final int OUTPUT_WINDOW = 120;
	private final int INTERVAL_THROUGHPUT = 1;

	@Value("${smpp.smsc.max.users}")
	private int MAX_USERS;

	
	
	
	
	
	
	
	public String getSMSC_IP() {
		return SMSC_IP;
	}

	public void setSMSC_IP(String sMSC_IP) {
		SMSC_IP = sMSC_IP;
	}

	public int getSMSC_PORT() {
		return SMSC_PORT;
	}

	public void setSMSC_PORT(int sMSC_PORT) {
		SMSC_PORT = sMSC_PORT;
	}

	public String getSYSTEM_ID() {
		return SYSTEM_ID;
	}

	public void setSYSTEM_ID(String sYSTEM_ID) {
		SYSTEM_ID = sYSTEM_ID;
	}

	public String getPASSWORD() {
		return PASSWORD;
	}

	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}

	public String getCONSOLIDATION_ID() {
		return CONSOLIDATION_ID;
	}

	public void setCONSOLIDATION_ID(String cONSOLIDATION_ID) {
		CONSOLIDATION_ID = cONSOLIDATION_ID;
	}

	public Integer getQUEUE_CAPACITY() {
		return QUEUE_CAPACITY;
	}

	public void setQUEUE_CAPACITY(Integer qUEUE_CAPACITY) {
		QUEUE_CAPACITY = qUEUE_CAPACITY;
	}

	public Integer getCONNECTION_WAITING_TIME() {
		return CONNECTION_WAITING_TIME;
	}

	public void setCONNECTION_WAITING_TIME(Integer cONNECTION_WAITING_TIME) {
		CONNECTION_WAITING_TIME = cONNECTION_WAITING_TIME;
	}

	public int getMAX_USERS() {
		return MAX_USERS;
	}

	public void setMAX_USERS(int mAX_USERS) {
		MAX_USERS = mAX_USERS;
	}

	public int getLEVEL_THROUGHPUT() {
		return LEVEL_THROUGHPUT;
	}

	public int getINPUT_WINDOW() {
		return INPUT_WINDOW;
	}

	public int getOUTPUT_WINDOW() {
		return OUTPUT_WINDOW;
	}

	public int getINTERVAL_THROUGHPUT() {
		return INTERVAL_THROUGHPUT;
	}
	
	
	
}
