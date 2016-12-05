package com.learning.collection;

import java.util.LinkedList;

public class DuplicateLinkedListMian {

	public static void main(String[] args) {
		DuplicateLinkedList<Integer> list = new DuplicateLinkedList<>();
		LinkedList<Integer> list1 = new LinkedList<>();
		
		for (int i = 0; i < 5; i++) {
			list.add(i);			
		}
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		list.remove(31);
		list.remove(3);
		list.remove(0);
		list.remove(4);
		System.out.println("------------");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		System.out.println("------------");
		System.out.println(list.size());
	}

}
