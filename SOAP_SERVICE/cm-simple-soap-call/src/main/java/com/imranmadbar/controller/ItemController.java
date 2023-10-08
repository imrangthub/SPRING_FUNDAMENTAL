package com.imranmadbar.controller;


import com.imranmadbar.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ItemController {

  @Autowired
  private ItemService itemService;

  @GetMapping("/categories")
  ResponseEntity<?> getCategories(
      @RequestParam("msisdn") String msisdn, @RequestParam("channel") String channel){
    return ResponseEntity.ok(itemService.getCategories(msisdn, channel).getCategories());
  }

}
