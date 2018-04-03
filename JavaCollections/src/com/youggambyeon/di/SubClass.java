package com.youggambyeon.di;

/**
 * Dependency Injection
 * 
 * Object wire.
 * 
 * Not created self dependency object. anyone put dependency object.
 * 
 * 
 */
public class SubClass {

	private SuperClass superClass = null;

	public SubClass(SuperClass superClass) {
		this.superClass = superClass;
	}

	public void callSuperClass() {
		String message = "DI";

		superClass.say(message);
	}

	public static void main(String[] args) {
		// outside
		SuperClass superClass = new SuperClass();

		// object injection.
		SubClass subClass = new SubClass(superClass);
		subClass.callSuperClass();
	}
}
