package com.urong.sample.service;

public interface PushService {

	public boolean pushMessage(String message);

	public boolean pushGroupMessage(String key, String topic);

}
