package com.urong.sample.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.request.async.DeferredResult;

public interface DeferredResultService {

	public DeferredResult<?> biteResponse(HttpServletResponse resp, HttpServletRequest req);

	public DeferredResult<?> biteGroupResponse(String key, HttpServletResponse resp);

}
