package com.younggambyeon.dip;

public class LowLevelServiceLayer implements MiddleInterface {

	@Override
	public String say() {
		return "저수준의 모듈입니다.";
	}

}
