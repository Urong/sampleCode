package com.urong.sample;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RestClient {

	private RestTemplate restTemplate;

	public RestClient() {
		restTemplate = new RestTemplate();
	}

	public void callServer() {
		String url = "http://10.0.0.205:8080/sample/call";
		ResponseEntity<?> respEntity = restTemplate.getForEntity(url, String.class);

		HttpStatus status = respEntity.getStatusCode();
		String body = respEntity.getBody().toString();

		if (HttpStatus.PARTIAL_CONTENT.equals(status)) {
			System.out.println("206");
		} else if (HttpStatus.OK.equals(status)) {
			System.out.println("200");
			System.out.println("body : " + body);
		}

		callServer();
	}

}
