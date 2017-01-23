package com.urong.sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.async.DeferredResult;

import com.urong.sample.component.DeferredResultStrore;

@Service
public class PushServiceImpl implements PushService {

	@Autowired
	private DeferredResultStrore deferredResultStore;

	@Override
	public boolean pushMessage(String message) {
		// send message or select data in DB.

		for (DeferredResult<String> deferredResult : deferredResultStore.getResponseBodyQueue()) {

			deferredResult.setResult("push messages : " + message);

			deferredResultStore.getResponseBodyQueue().remove(deferredResult);
		}

		return true;
	}

}
