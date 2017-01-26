package com.urong.sample.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.async.DeferredResult;

import com.urong.sample.component.DeferredResultStrore;
import com.urong.sample.model.InterfaceModel;

@Service
public class DeferredResultServiceImpl implements DeferredResultService {

	@Autowired
	private DeferredResultStrore deferredResultStore;

	@Override
	public DeferredResult<?> biteResponse(final HttpServletResponse resp, HttpServletRequest req) {

		final DeferredResult<String> defResult = new DeferredResult<String>(deferredResultStore.getResultTimeOut());

		startRemover(resp, defResult);

		deferredResultStore.getResponseBodyQueue().add(defResult);

		return defResult;
	}

	@Override
	public DeferredResult<?> biteGroupResponse(String key, final HttpServletResponse resp) {

		final DeferredResult<InterfaceModel> defResult = new DeferredResult<InterfaceModel>(
				deferredResultStore.getResultTimeOut());

		List<DeferredResult<InterfaceModel>> defResultList = null;

		startRemover(resp, defResult);

		if (deferredResultStore.getGroupMap().containsKey(key)) {

			defResultList = deferredResultStore.getGroupMap().get(key);
			defResultList.add(defResult);

		} else {

			defResultList = new ArrayList<DeferredResult<InterfaceModel>>();
			defResultList.add(defResult);
			deferredResultStore.getGroupMap().put(key, defResultList);

		}

		return defResult;
	}

	private void startRemover(final HttpServletResponse resp, final DeferredResult<?> defResult) {
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
	}

}
