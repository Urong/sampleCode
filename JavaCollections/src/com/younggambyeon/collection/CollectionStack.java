package com.younggambyeon.collection;

import java.util.Stack;

/**
 * [ Stack ]
 * 
 * use Vector
 * 
 * The object at the top of this stack (the last item)
 * 
 * LIFO
 * 
 */
public class CollectionStack {

	public static void main(String a[]) {
		Stack<Integer> s = new Stack<Integer>();
		s.push(null);
		s.push(2);
		s.push(34);
		s.push(2222);

		System.out.println(s);

		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
	}

}
