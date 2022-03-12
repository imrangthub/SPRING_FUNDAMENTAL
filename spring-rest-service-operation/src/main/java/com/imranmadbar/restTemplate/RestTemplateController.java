package com.imranmadbar.restTemplate;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RestTemplateController {

	@Autowired
	public RestTemplate restTemplate;

	@GetMapping("/restTmp4")
	public String restTmp4() {
		final Charset UTF_8 = Charset.forName("UTF-8");
		final Charset ISO = Charset.forName("ISO-8859-1");
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

		String url = "http://localhost:8080/producer/bgn1";

		String resultStr = restTemplate.getForObject(url, String.class);
		System.out.println("ResultBang: " + resultStr);

		String resultStr2 = new String(resultStr.getBytes(ISO), UTF_8);
		System.out.println("ResultBang2: " + resultStr2);

		if (resultStr2.equals("মোবাইলে বাংলা লিখন")) {
			System.out.println("Match found !");
		} else {
			System.out.println("No Match found !");
		}

		return resultStr2;
	}

	@GetMapping("/restTmp3")
	public String restTmp3() {
		Map<String, Object> map = new HashMap<>();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

		String url = "https://mocki.io/v1/eaad2920-0ebf-48ac-a790-d594e428ca58";

		map = restTemplate.getForObject(url, HashMap.class);
		System.out.println("ResultVal: " + map.get("key"));

		if (map.get("key").equals("মোবাইলে বাংলা লিখন")) {

			System.out.println("Match found !");
		} else {
			System.out.println("No Match found !");
		}

		return map.get("key").toString();
	}

	@GetMapping("/restTmp2")
	public String restTmp2() {
		Map<String, Object> map = new HashMap<>();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

		String url = "https://mocki.io/v1/5cda77a7-d557-444c-8712-482ab208fa02";

		map = restTemplate.getForObject(url, HashMap.class);
		System.out.println("ResultVal: " + map.get("key"));

		if (map.get("key").equals("Hello World")) {
			System.out.println("Match found !");
		} else {
			System.out.println("No Match found !");
		}

		return map.get("key").toString();
	}

	@GetMapping("/restTmp1")
	public String restTmp1() {

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

		String url = "https://mocki.io/v1/eaad2920-0ebf-48ac-a790-d594e428ca58";

		String resultStr = restTemplate.getForObject(url, String.class);
		System.out.println("Result: " + resultStr);

		return resultStr;
	}

	@GetMapping("/restTmp0")
	public String restTmp0() {
		String url = "https://mocki.io/v1/eaad2920-0ebf-48ac-a790-d594e428ca58";
		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", "application/json");
		headers.setAccept(Arrays.asList(MediaType.ALL));
		HttpEntity<Void> requestEntity = new HttpEntity<>(headers);

		ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, requestEntity, String.class);
		System.out.println("restTmp0: " + response.getBody());

		return "Hello World Spring  Web Application.";
	}

}
