package com.urong.sample.service;

import java.util.List;
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

		for (DeferredResult<String> deferredResult : deferredResultStore.getResponseBodyQueue()) {

			deferredResult.setResult("push messages : " + message);

			deferredResultStore.getResponseBodyQueue().remove(deferredResult);
		}

		return true;
	}

	@Override
	public boolean pushGroupMessage(String key, String topic) {

		// select data in DB.

		List<DeferredResult<InterfaceModel>> defResultList = null;

		InterfaceModel model = new InterfaceModel();
		model.setMessage("default Message ~");

		if (deferredResultStore.getGroupMap().containsKey(key)) {
			defResultList = deferredResultStore.getGroupMap().get(key);

			for (DeferredResult<InterfaceModel> deferredResult : defResultList) {
				deferredResult.setResult(model);
			}
		}

		return true;
	}

}
