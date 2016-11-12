package com.learning.leetcode;

import java.util.Iterator;
import java.util.LinkedList;

public class RemoveDuplicateLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LinkedList<Integer> list = new  LinkedList<>();
		LinkedList<Integer> duplicate = new  LinkedList<>();
		list.add(1);
		list.add(2);
		list.add(2);
		list.add(2);
		list.add(3);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(5);
		list.add(6);
		list.add(6);
		list.add(6);
		
		int current = 0;
		int next = 0;
		
		list.forEach( (e) -> System.out.println(e));
		System.out.println("-------------------------------");
		for (int i = 0; i < list.size(); i++) {
			current = list.get(i);
			if(i < list.size()-1)
				next = list.get(i+1);
			else
				duplicate.add(current);
			if(current != next){
				/*list.remove(i);*/
				duplicate.add(current);
			}
		}
		System.out.println("-------------------------------");
		
		duplicate.forEach( (e) -> System.out.println(e));

	}

}
