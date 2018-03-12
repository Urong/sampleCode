package com.younggambyeon.test;

public class TestClassByAbstractAndInterface extends AbstractClass3 implements Interface2, Interface1 {

	@Override
	public String say2() {
		return "안녕하세요. 추상 클래스를 상속받아 재정의합니다.";
	}
	
	@Override
	public String say() {
		// TODO Auto-generated method stub
		return super.say();
	}

	@Override
	public String say3() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	String say4() {
		// TODO Auto-generated method stub
		return null;
	}


}
