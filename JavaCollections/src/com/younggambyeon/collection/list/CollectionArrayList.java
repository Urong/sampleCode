package com.younggambyeon.collection.list;

import java.util.ArrayList;
import java.util.List;

/**
 * [ ArrayList ]
 * 
 * public class ArrayList<E> extends AbstractList<E> implements List<E>,
 * RandomAccess, Cloneable, Serializable
 * 
 * 
 * 1) Java ArrayList class can contain duplicate elements.
 * 
 * 2) Java ArrayList class maintains insertion order.
 * 
 * 3) Java ArrayList class is non synchronized.
 * 
 * 4) Java ArrayList allows random access because array works at the index
 * basis.
 * 
 * 5) In Java ArrayList class, manipulation is slow because a lot of shifting
 * needs to be occurred if any element is removed from the array list.
 * 
 * 
 */
public class CollectionArrayList {

	public static void main(String[] args) {

		List<String> arrayList = new ArrayList<String>();

		// It is used to insert the specified element at the specified position index in
		// a list.
		arrayList.add(null);
		arrayList.add("june");
		arrayList.add("heeny");
		arrayList.add(null);

		System.out.println(arrayList);

		for (String string : arrayList) {
			System.out.println(string);
		}

	}
}
