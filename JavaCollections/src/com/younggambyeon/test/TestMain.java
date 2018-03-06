package com.younggambyeon.test;

public class TestMain {

	public static void main(String[] args) {
		
		TestInterface interfaceA = new TestClass();
		
		TestAbstract abstractA = new TestClass2();

		System.out.println(abstractA.b);
		System.out.println(abstractA.say());
		System.out.println(abstractA.say2());
		System.out.println(interfaceA.say());
	}
}
