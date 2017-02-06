package com.urong.sample.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.servlet.ModelAndView;

import com.urong.sample.component.DeferredResultStrore;
import com.urong.sample.service.DeferredResultService;
import com.urong.sample.service.PushService;

@Controller
public class SampleController {

	@Autowired
	private PushService pushService;

	@Autowired
	private DeferredResultService deferredResultService;

	@Autowired
	private DeferredResultStrore deferredResultStore;

	@RequestMapping(value = "/test")
	public ModelAndView showTestPage(ModelAndView mav) {
		mav.setViewName("html/test");

		return mav;
	}

	@RequestMapping(value = "/call")
	public @ResponseBody DeferredResult<?> deferredResult(HttpServletResponse resp, HttpServletRequest req) {
		return deferredResultService.biteResponse(resp, req);
	}

	@RequestMapping(value = "/push/{message}")
	public @ResponseBody boolean processResult(@PathVariable String message) {
		return pushService.pushMessage(message);
	}

	// ----------- group ------------

	@RequestMapping(value = "/call/group/{groupKey}")
	public @ResponseBody DeferredResult<?> callGroup(@PathVariable String groupKey, HttpServletResponse resp) {
		return deferredResultService.biteGroupResponse(groupKey, resp);
	}

	@RequestMapping(value = "/push/group/{groupKey}/topic/{topic}")
	public @ResponseBody boolean pushGroup(@PathVariable String groupKey, @PathVariable String topic,
			HttpServletResponse resp) {
		return pushService.pushGroupMessage(groupKey, topic, resp);
	}

	@RequestMapping(value = "/storage/count")
	public @ResponseBody String getStorageCount() {

		int mapCount = deferredResultStore.getGroupMap().size();
		int queueCount = deferredResultStore.getResponseBodyQueue().size();

		return "queueCount : " + queueCount + " // mapCount : " + mapCount;
	}
}
