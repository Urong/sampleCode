package com.younggambyeon.collection.list;

import java.util.LinkedList;
import java.util.List;

/**
 * [ LinkedList ]
 * 
 * public class LinkedList<E> extends AbstractSequentialList<E> implements
 * List<E>, Deque<E>, Cloneable, Serializable
 * 
 * Deque => queue + stack
 * 
 * 
 * LinkedList uses doubly linked list to store the elements.
 * 
 * Manipulation(data) with LinkedList is faster than ArrayList. no bit shifting
 * is required in memory.
 * 
 * 
 * 1) Java LinkedList class can contain duplicate elements.
 * 
 * 2) Java LinkedList class maintains insertion order.
 * 
 * 3) Java LinkedList class is non synchronized.
 * 
 * 4) In Java LinkedList class, manipulation is fast because no shifting needs
 * to be occurred.
 * 
 * 5) Java LinkedList class can be used as list, stack or queue.
 *
 * 
 **/
public class CollectionLinkedList {

	public static void main(String[] args) {
		List<String> linkedList = new LinkedList<String>();

		// add = Appends the specified element to the end of this list.
		// 1. linkLast(element) in LikedList "add"
		// 2. Links e as last element.
		// 3. if list is null => create newNode(first)
		// 4. else use node(last) next.
		// 5. size ++ and modCount++
		linkedList.add(null);
		linkedList.add("june");
		linkedList.add("heeny");
		linkedList.add(null);

		System.out.println("linkedlist: " + linkedList);

		for (String string : linkedList) {
			System.out.println(string);
		}
	}
}
