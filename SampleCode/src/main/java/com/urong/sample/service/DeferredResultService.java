package com.urong.sample.service;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.request.async.DeferredResult;

public interface DeferredResultService {

	public DeferredResult<String> biteResponse(HttpServletResponse resp);
}
