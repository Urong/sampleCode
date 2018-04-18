package com.younggambyeon.test;

import java.util.Date;
import java.util.Stack;

public class TestMain {

	public static void main(String[] args)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException {

		Interface2 interfaceA = new TestClassByInterface();
		Interface2 interfaceB = new TestClassByInterface2();

		AbstractClass2 abstractA = new TestClassByAbstractAndInterface();

		TestMain main = new TestMain();
		main.TestDependencyInjection(interfaceA);
		main.TestDependencyInjection(interfaceB);

		System.out.println(abstractA.b);
		System.out.println(abstractA.say());
		System.out.println(abstractA.say2());
		System.out.println(interfaceA.say());

		String str = "토마잉";

		StringBuilder builder = new StringBuilder(str);

		if (str.equals(builder.reverse().toString())) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}

		char[] in = str.toCharArray();

		Stack<String> stack = new Stack<String>();

		for (char c : in) {
			stack.add(String.valueOf(c));
		}

		String input = "";

		for (int i = 0; i < in.length; i++) {
			input += stack.pop();
		}

		System.out.println(input);

		// java reflection.
		Date date = (Date) Class.forName("java.util.Date").newInstance();

		System.out.println(date.getTime());
		System.out.println("!");
		int[][] results = new int[3][3];
		System.out.println(results.length);

		String a = "123";

		int b = Integer.parseInt(a);

		// return String object
		String c = a.valueOf(b);

		System.out.println(c);

		int aa = 8;
		int bb = 12;

		System.out.println(GCF(aa, bb));
		System.out.println(LCM(aa, bb));
	}

	public static int GCF(int a, int b) {
		if (b == 0) {
			return a;
		} else {
			return (GCF(b, a % b));
		}
	}

	public static int LCM(int a, int b) {
		return (a * b) / GCF(a, b);
	}

	public void TestDependencyInjection(Interface2 interface2) {

		System.out.println(interface2.getClass());
	}
}
