package com.urong.sample.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.servlet.ModelAndView;
import com.urong.sample.service.DeferredResultService;
import com.urong.sample.service.PushService;

@Controller
public class SampleController {

	@Autowired
	private PushService pushService;

	@Autowired
	private DeferredResultService deferredResultService;

	@RequestMapping(value = "/test")
	public ModelAndView showTestPage(ModelAndView mav) {
		mav.setViewName("html/test");

		return mav;
	}

	@RequestMapping(value = "/call")
	public @ResponseBody DeferredResult<String> deferredResult(HttpServletResponse resp) {
		return deferredResultService.biteResponse(resp);
	}

	@RequestMapping(value = "/push/{message}")
	public @ResponseBody boolean processResult(@PathVariable String message) {
		return pushService.pushMessage(message);
	}

	@RequestMapping(value = "/test/1")
	public @ResponseBody String test(HttpServletResponse resp) {
		return "test";
	}

}
