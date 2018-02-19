package com.younggambyeon.collection.set;

import java.util.HashSet;
import java.util.Iterator;

/**
 * [ hashSet ]
 * 
 * 
 * public class HashSet<E> extends AbstractSet<E> implements Set<E>, Cloneable,
 * Serializable
 * 
 * Java HashSet class is used to create a collection that uses a hash table for
 * storage. It inherits the AbstractSet class and implements Set interface.
 * 
 * 
 * 1) HashSet stores the elements by using a mechanism called hashing.
 * 
 * 2) HashSet contains unique elements only.
 * 
 * 
 * Difference between List and Set => List can contain duplicate elements
 * whereas Set contains unique elements only.
 * 
 * 
 */
public class CollectionHashSet {

	public static void main(String[] args) {
		HashSet<String> set = new HashSet<String>();
		set.add(null);
		set.add("june");
		set.add("heeny");
		set.add(null);

		System.out.println(set);

		Iterator<String> itr = set.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}

	}
}
