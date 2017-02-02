package com.urong.sample;

public class App {

	public static void main(String[] args) {
		final RestClient client = new RestClient();
		final String groupKey = "default";

		Thread thread = new Thread(new Runnable() {
			public void run() {
				client.callServer();

			}
		});
		thread.start();

		client.callServerByGroupKey(groupKey);

	}

}
