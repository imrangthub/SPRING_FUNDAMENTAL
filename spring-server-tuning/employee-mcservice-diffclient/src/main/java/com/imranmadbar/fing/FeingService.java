package com.imranmadbar.fing;

import org.springframework.stereotype.Service;

@Service
public class FeingService {

	public FeingService(IntregrationFeingClient intregrationFeingClient) {
		this.intregrationFeingClient = intregrationFeingClient;

	}

	private IntregrationFeingClient intregrationFeingClient;

	public String getEmpEnfo() {
		return intregrationFeingClient.getEmpEnfo();

	}

	public String getEmpEnfo1() {
		return intregrationFeingClient.getEmpEnfo1();

	}

}
