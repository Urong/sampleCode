package com.urong.sample.component;

import java.util.HashMap;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.async.DeferredResult;

import com.urong.sample.model.InterfaceModel;

@Component
public class DeferredResultStrore {

	private Queue<DeferredResult<String>> responseBodyQueue;
	private HashMap<String, List<DeferredResult<InterfaceModel>>> groupMap;
	private final long resultTimeOut;

	public DeferredResultStrore() {
		responseBodyQueue = new LinkedBlockingQueue<DeferredResult<String>>();
		groupMap = new HashMap<String, List<DeferredResult<InterfaceModel>>>();
		// 6000
		resultTimeOut = 6000 * 1000;
	}

	public Queue<DeferredResult<String>> getResponseBodyQueue() {
		return responseBodyQueue;
	}

	public HashMap<String, List<DeferredResult<InterfaceModel>>> getGroupMap() {
		return groupMap;
	}

	public long getResultTimeOut() {
		return resultTimeOut;
	}

}
