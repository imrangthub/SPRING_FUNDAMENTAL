package com.imranmadbar.repository.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient(name = "my-feing", url = "${backEndNode.url}")
public interface MyFeignClient {

    @PostMapping(
            value = "/scripts/soapTicket.exe?action=ticket", consumes = "text/xml; charset=UTF-8")
    String doRequest(@RequestBody String request);
}
