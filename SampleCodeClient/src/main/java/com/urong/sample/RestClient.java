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
		Object body = respEntity.getBody();

		if (HttpStatus.PARTIAL_CONTENT.equals(status)) {
			System.out.println("HttpStatus : 206");

		} else if (HttpStatus.OK.equals(status)) {
			System.out.println("HttpStatus : 200");

		} else {
			// log
		}

		System.out.println("body : " + body.toString());
		System.out.println("=========================");
		callServer();

	}

	public void callServerByGroupKey(String groupKey) {
		String url = "http://10.0.0.205:8080/sample/call/group/" + groupKey;
		ResponseEntity<?> respEntity = restTemplate.getForEntity(url, String.class);

		HttpStatus status = respEntity.getStatusCode();
		Object model = respEntity.getBody();

		if (HttpStatus.PARTIAL_CONTENT.equals(status)) {
			System.out.println("group HttpStatus : 206");

		} else if (HttpStatus.OK.equals(status)) {
			System.out.println("group HttpStatus : 200");

		} else {
			// log
		}

		System.out.println("group body : " + model.toString());
		System.out.println("=========================");
		callServerByGroupKey(groupKey);
	}

}
