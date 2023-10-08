package com.imranmadbar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients("com.imranmadbar.repository.client")
public class SimpleSopCmApplication {

  public static void main(String[] args) {
    SpringApplication.run(SimpleSopCmApplication.class, args);
  }
}
