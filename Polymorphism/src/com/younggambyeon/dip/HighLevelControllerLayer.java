package com.younggambyeon.dip;

public class HighLevelControllerLayer {

	public static void main(String[] args) {
		// 고수준이 정희한 추상화 타입
		MiddleInterface lowLevel = new LowLevelServiceLayer();

		// 저수준의 모듈이 고수준의 모듈이 정의한 추상화 타입에 의존해야 한다.
		System.out.println(lowLevel.say());

	}
}
