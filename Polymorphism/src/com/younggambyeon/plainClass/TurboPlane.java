package com.younggambyeon.plainClass;

import com.younggambyeon.PlainInterface.Turbo;

public class TurboPlane extends Plane implements Turbo {

	@Override
	public void boost() {
		// 가속
	}

	public static void main(String[] args) {
		// 다형성
		TurboPlane tp = new TurboPlane();
		tp.fly();
		tp.boost();

		// --------------------
		Turbo turbo = tp;
		turbo.boost();

		Plane plane = tp;
		plane.fly();
	}

}
