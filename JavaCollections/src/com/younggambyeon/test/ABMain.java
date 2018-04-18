package com.younggambyeon.test;

public class ABMain {

	public static void main(String[] args) {
		B b = new B();
		A a = b;
		a.a();
		
		System.out.println("  ================  ");
		
		A aa = new A();
		aa.a();
	}
}
