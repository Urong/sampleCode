package com.urong.sample.model;

public class InterfaceModel {

	private String message;

	private int idx;
	private String id;

	// DB Column

	public InterfaceModel() {
		// TODO Auto-generated constructor stub
	}

	public InterfaceModel(String message, int idx, String id) {
		this.message = message;
		this.idx = idx;
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
