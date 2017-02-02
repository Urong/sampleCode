package com.urong.sample.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.async.DeferredResult;
import com.urong.sample.component.DeferredResultStrore;
import com.urong.sample.model.InterfaceModel;

@Service
public class PushServiceImpl implements PushService {

	@Autowired
	private DeferredResultStrore deferredResultStore;

	@Override
	public boolean pushMessage(String message) {

		if (!deferredResultStore.getResponseBodyQueue().isEmpty()) {

			for (DeferredResult<String> deferredResult : deferredResultStore.getResponseBodyQueue()) {

				deferredResult.setResult(message);
			}

			deferredResultStore.getResponseBodyQueue().remove();
		}

		return true;
	}

	@Override
	public boolean pushGroupMessage(String key, String topic, HttpServletResponse resp) {
		List<DeferredResult<InterfaceModel>> defResultList = null;

		// select data in DB.
		InterfaceModel model = new InterfaceModel();
		model.setMessage("그룹 메시지~~");
		model.setId(key);

		if (deferredResultStore.getGroupMap().containsKey(key)) {
			defResultList = deferredResultStore.getGroupMap().get(key);

			for (DeferredResult<InterfaceModel> deferredResult : defResultList) {
				deferredResult.setResult(model);
			}

			deferredResultStore.getGroupMap().remove(key);
		}

		return true;
	}

}
