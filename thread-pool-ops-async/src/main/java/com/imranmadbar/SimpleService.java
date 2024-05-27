package com.imranmadbar;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class SimpleService {

	@Async("customTaskExecutor")
	public void asyncMethod() {
		System.out.println("Executing method asynchronously - " + Thread.currentThread().getName());
		try {
			Thread.sleep(2000); // Simulate a long-running task
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Execution completed - " + Thread.currentThread().getName());
	}

}
