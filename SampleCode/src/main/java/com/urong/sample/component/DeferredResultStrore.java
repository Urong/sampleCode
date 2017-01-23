package com.urong.sample.component;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.async.DeferredResult;

@Component
public class DeferredResultStrore {

	private Queue<DeferredResult<String>> responseBodyQueue;

	public DeferredResultStrore() {
		responseBodyQueue = new LinkedBlockingQueue<DeferredResult<String>>();
	}

	public Queue<DeferredResult<String>> getResponseBodyQueue() {
		return responseBodyQueue;
	}

	public void setResponseBodyQueue(LinkedBlockingQueue<DeferredResult<String>> responseBodyQueue) {
		this.responseBodyQueue = responseBodyQueue;
	}

}
