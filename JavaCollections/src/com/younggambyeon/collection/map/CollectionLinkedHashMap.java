package com.younggambyeon.collection.map;

import java.util.LinkedHashMap;

/**
 * [ LinkedHashMap ]
 * 
 * public class LinkedHashMap<K,V> extends HashMap<K,V> implements Map<K,V>
 * 
 * Java LinkedHashMap class is Hash table and Linked list implementation of the
 * Map interface, with predictable iteration order. It inherits HashMap class
 * and implements the Map interface.
 * 
 * 
 * 1) A LinkedHashMap contains values based on the key.
 * 
 * 2) It contains only unique elements.
 * 
 * 3) It may have one null key and multiple null values.
 * 
 * 4) It is same as HashMap instead maintains insertion order.
 * 
 * 
 */
public class CollectionLinkedHashMap {

	public static void main(String[] args) {

		LinkedHashMap<Integer, String> hm = new LinkedHashMap<Integer, String>();

		hm.put(2, "heeny");
		hm.put(1, "june");
		hm.put(null, "june");
		hm.put(null, null);

		System.out.println(hm);

	}
}
