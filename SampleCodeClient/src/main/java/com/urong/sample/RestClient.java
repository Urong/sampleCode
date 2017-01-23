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

		ResponseEntity<?> respEntity = restTemplate.getForEntity(url, ResponseEntity.class);

		HttpStatus status = respEntity.getStatusCode();
		String body = (String) respEntity.getBody();

		if (HttpStatus.NO_CONTENT.equals(status)) {
			// 203
			System.out.println("203");
		} else if (HttpStatus.OK.equals(status)) {
			// 200
			System.out.println("OK");
		}

		System.out.println("body : " + body);

		callServer();
	}

}
