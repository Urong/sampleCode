package com.urong.wedding.model;

public class Rsvp {

	private int idx;

	private String name;
	private String flag;

	private String date;

	public Rsvp() {
		// TODO Auto-generated constructor stub
		//dfgdfg
	}

	public Rsvp(int idx, String name, String flag, String date) {
		this.idx = idx;
		this.name = name;
		this.flag = flag;
		this.date = date;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
