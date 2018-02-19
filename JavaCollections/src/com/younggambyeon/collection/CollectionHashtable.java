package com.younggambyeon.collection;

import java.util.Hashtable;

/**
 * [ Hashtable ]
 * 
 * public class Hashtable<K,V> extends Dictionary<K,V> implements Map<K,V>,
 * Cloneable, Serializable
 * 
 * Java Hashtable class implements a hashtable, which maps keys to values. It
 * inherits Dictionary class and implements the Map interface.
 * 
 * 
 * 1) A Hashtable is an array of list. Each list is known as a bucket. The
 * position of bucket is identified by calling the hashcode() method. A
 * Hashtable contains values based on the key.
 * 
 * 2) It contains only unique elements.
 * 
 * 3) It may have not have any null key or value.
 * 
 * 4) It is synchronized.
 * 
 */
public class CollectionHashtable {

	public static void main(String[] args) {
		Hashtable<Integer, String> htable = new Hashtable<Integer, String>();

		htable.put(1, "june");
		htable.put(2, "heeny");

		// not null => It may have not have any null key or value.
		// htable.put(null, "bab");
		// htable.put(null, null);
		// htable.put(3, null);

		System.out.println(htable);
	}
}
