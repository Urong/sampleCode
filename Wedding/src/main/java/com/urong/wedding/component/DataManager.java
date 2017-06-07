package com.urong.wedding.component;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import org.springframework.stereotype.Component;

import com.urong.wedding.model.Rsvp;

@Component
public class DataManager {

	private Queue<Rsvp> userQueue;

	public DataManager() {
		userQueue = new LinkedBlockingQueue<Rsvp>();
	}

	public synchronized Queue<Rsvp> getUserQueue() {
		return userQueue;
	}

}
