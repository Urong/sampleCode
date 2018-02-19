package com.younggambyeon.collection;

import java.util.TreeMap;

/**
 * [ TreeMap ]
 * 
 * public class TreeMap<K,V> extends AbstractMap<K,V> implements
 * NavigableMap<K,V>, Cloneable, Serializable
 * 
 * Java TreeMap class implements the Map interface by using a tree. It provides
 * an efficient means of storing key/value pairs in sorted order.
 * 
 * 
 * 1) A TreeMap contains values based on the key. It implements the NavigableMap
 * interface and extends AbstractMap class.
 * 
 * 2) It contains only unique elements. It cannot have null key but can have
 * multiple null values.
 * 
 * 3) It is same as HashMap instead maintains ascending order.
 * 
 * 
 */
public class CollectionTreeMap {

	public static void main(String[] args) {
		TreeMap<Integer, String> treeMap = new TreeMap<Integer, String>();

		treeMap.put(1, "june");
		treeMap.put(2, "heeny");

		// not null
		// if (key == null) throw new NullPointerException();
		// treeMap.put(null, null);
		// treeMap.put(null, "bab");

		System.out.println(treeMap);
	}
}
