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

		removeObserver(resp, defResult, null);

		deferredResultStore.getResponseBodyQueue().add(defResult);

		return defResult;
	}

	@Override
	public DeferredResult<?> biteGroupResponse(String key, final HttpServletResponse resp) {

		final DeferredResult<InterfaceModel> defResult = new DeferredResult<InterfaceModel>(
				deferredResultStore.getResultTimeOut());

		List<DeferredResult<InterfaceModel>> defResultList = null;

		removeObserver(resp, defResult, key);

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

	private void removeObserver(final HttpServletResponse resp, final DeferredResult<?> defResult, final String key) {

		defResult.onCompletion(new Runnable() {
			public void run() {
				if (key != null) {
					List<DeferredResult<InterfaceModel>> defResultList = deferredResultStore.getGroupMap().get(key);

					if (defResultList != null) {
						for (DeferredResult<InterfaceModel> deferredResult : defResultList) {
							if (deferredResult.hashCode() == defResult.hashCode()) {
								defResultList.remove(deferredResult);
							}
						}
					}

				} else {
					if (!deferredResultStore.getResponseBodyQueue().isEmpty()) {
						deferredResultStore.getResponseBodyQueue().remove(defResult);
					}
				}
			}
		});

		defResult.onTimeout(new Runnable() {
			public void run() {
				// 206
				resp.setStatus(HttpServletResponse.SC_PARTIAL_CONTENT);

				if (key != null) {
					List<DeferredResult<InterfaceModel>> defResultList = deferredResultStore.getGroupMap().get(key);

					if (defResultList != null) {
						for (DeferredResult<InterfaceModel> deferredResult : defResultList) {
							if (deferredResult.hashCode() == defResult.hashCode()) {

								InterfaceModel model = new InterfaceModel();
								model.setId(key);
								model.setMessage("onTimeout");

								deferredResult.setErrorResult(model);
								defResultList.remove(deferredResult);
							}
						}
					}

				} else {
					defResult.setErrorResult("onTimeout");
					deferredResultStore.getResponseBodyQueue().remove(defResult);
				}
			}
		});
	}

}
