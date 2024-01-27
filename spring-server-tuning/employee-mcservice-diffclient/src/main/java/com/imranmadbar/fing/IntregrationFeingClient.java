package com.imranmadbar.fing;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;


@FeignClient(value = "IntregrationFeingClient",url = "${intSvc.url}")
public interface IntregrationFeingClient {

	@GetMapping(value = "/emp1")
	String getEmpEnfo1();

	@GetMapping(value = "/emp3")
	String getEmpEnfo3();

}
