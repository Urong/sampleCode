package com.younggambyeon.test;

public abstract class AbstractClass3 extends AbstractClass2 {

	public AbstractClass3() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String say2() {
		return "상속해서 재정의";
	}

	@Override
	public String say() {
		return super.say();
	}

	abstract String say4();
	
}
