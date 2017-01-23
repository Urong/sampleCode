package com.urong.sample.service;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.async.DeferredResult;

import com.urong.sample.component.DeferredResultStrore;

@Service
public class DeferredResultServiceImpl implements DeferredResultService {

	@Autowired
	private DeferredResultStrore deferredResultStore;

	@Override
	public DeferredResult<String> biteResponse(final HttpServletResponse resp) {
		// 10min -> success
		long resultTimeOut = 600 * 1000;
		final DeferredResult<String> defResult = new DeferredResult<String>(resultTimeOut);

		defResult.onCompletion(new Runnable() {
			public void run() {
				deferredResultStore.getResponseBodyQueue().remove(defResult);
			}
		});

		defResult.onTimeout(new Runnable() {
			public void run() {
				defResult.setErrorResult("onTimeout");
				// 206
				resp.setStatus(HttpServletResponse.SC_PARTIAL_CONTENT);
				deferredResultStore.getResponseBodyQueue().remove(defResult);
			}
		});

		deferredResultStore.getResponseBodyQueue().add(defResult);

		return defResult;
	}

}
