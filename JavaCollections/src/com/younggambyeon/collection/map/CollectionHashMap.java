package com.younggambyeon.collection.map;

import java.util.HashMap;

/**
 * [ HashMap ]
 * 
 * public class HashMap<K,V> extends AbstractMap<K,V> implements Map<K,V>,
 * Cloneable, Serializable
 * 
 * Java HashMap class implements the map interface by using a hashtable. It
 * inherits AbstractMap class and implements Map interface.
 * 
 * 1) A HashMap contains values based on the key.
 * 
 * 2) It contains only unique elements.
 * 
 * 3) It may have one null key and multiple null values.
 * 
 * 4) It maintains no order.
 * 
 * 5) HashMap is non synchronized.
 * 
 * 
 */
public class CollectionHashMap {

	public static void main(String[] args) {
		HashMap<Integer, String> hm = new HashMap<Integer, String>();

		hm.put(1, "june");
		hm.put(2, "heeny");
		hm.put(3, "bab");
		hm.put(null, "jackson"); // key is null.
		hm.put(4, null);
		hm.put(null, null); // key and value is null.

		// output is null(key) and null(value).
		// contains only unique elements. key(null) is overwrite.
		System.out.println(hm);

	}
}
