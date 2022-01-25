package com.imranmadbar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.imranmadbar.config.SoapClient;
import com.imranmadbar.soap.bindings.ItemRequest;
import com.imranmadbar.soap.bindings.ItemResponse;

@RestController
public class ItemController {

	@Autowired
	SoapClient soapClient;

	@PostMapping("/item")
	public ItemResponse item(@RequestBody ItemRequest itemRequest) {
		return soapClient.getItemInfo(itemRequest);
	}

}