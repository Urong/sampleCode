package com.urong.sample;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RestClient {

	private RestTemplate restTemplate;

	public RestClient() {
		restTemplate = new RestTemplate();
	}

	public void callServer() {
		String url = "http://10.0.0.205:8080/sample/call";

		String returnString = restTemplate.getForObject(url, String.class);

		ResponseEntity<?> respEntity = restTemplate.getForEntity(url, ResponseEntity.class);

		if ("onTimeout".equals(returnString)) {
			callServer();
		}

		System.out.println("returnString : " + returnString);
	}

	public static void main(String[] args) {
		RestClient client = new RestClient();
		client.callServer();
	}

}
