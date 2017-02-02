package com.urong.sample.service;

import javax.servlet.http.HttpServletResponse;

public interface PushService {

	public boolean pushMessage(String message);

	public boolean pushGroupMessage(String key, String topic, HttpServletResponse resp);

}
