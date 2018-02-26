package com.younggambyeon.collection.set;

import java.util.LinkedHashSet;

/**
 * [ LinkedHashSet ]
 * 
 * public class LinkedHashSet<E> extends HashSet<E> implements Set<E>,
 * Cloneable, Serializable
 * 
 * Java LinkedHashSet class is a Hash table and Linked list implementation of
 * the set interface. It inherits HashSet class and implements Set interface.
 * 
 * 
 * 1) Contains unique elements only like HashSet.
 * 
 * 2) Provides all optional set operations, and permits null elements.
 * 
 * 3) Maintains insertion order.
 * 
 * 
 */
public class CollectionLinkedHashSet {

	public static void main(String[] args) {
		LinkedHashSet<String> linkedHashSet = new LinkedHashSet<String>();

		linkedHashSet.add(null);
		linkedHashSet.add("june");
		linkedHashSet.add("heeny");
		linkedHashSet.add(null);

		System.out.println(linkedHashSet);

		for (String str : linkedHashSet) {
			System.out.println(str);
		}

	}
}
