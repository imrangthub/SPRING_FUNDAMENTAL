package com.imranmadbar.fing;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;


@FeignClient(value = "IntregrationFeingClient",url = "${intSvc.url}")
public interface IntregrationFeingClient {

	@GetMapping(value = "/intsc")
	String getEmpEnfo();

	@GetMapping(value = "/intsc1")
	String getEmpEnfo1();

}
