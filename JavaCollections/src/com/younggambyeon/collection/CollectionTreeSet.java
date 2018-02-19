package com.younggambyeon.collection;

import java.util.TreeSet;

/**
 * [ TreeSet ]
 * 
 * public class TreeSet<E> extends AbstractSet<E> implements NavigableSet<E>,
 * Cloneable, Serializable
 * 
 * Java TreeSet class implements the Set interface that uses a tree for storage.
 * It inherits AbstractSet class and implements NavigableSet interface. The
 * objects of TreeSet class are stored in ascending order.
 * 
 * 
 * 1) Contains unique elements only like HashSet.
 * 
 * 2) Access and retrieval times are quiet fast.
 * 
 * 3) Maintains ascending order.
 * 
 * 
 */
public class CollectionTreeSet {

	public static void main(String[] args) {
		TreeSet<String> treeSet = new TreeSet<String>();

		// not null
		// treeSet.add(null);
		treeSet.add("june");
		treeSet.add("bab");
		treeSet.add("heeny");

		System.out.println(treeSet);

		for (String string : treeSet) {
			System.out.println(string);
		}
	}

}
