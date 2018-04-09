package com.younggambyeon.lsp;

public class SubClass extends SuperClass {

	public SubClass() {
		// TODO Auto-generated constructor stub
	}

	public void someMethod(SuperClass sc) {
		sc.someMethod();
	}
	
	public static void main(String[] args) {
		SubClass sub = new SubClass();
		
		sub.someMethod(sub);
	}
}
