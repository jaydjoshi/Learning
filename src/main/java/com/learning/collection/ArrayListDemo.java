package com.learning.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.CopyOnWriteArrayList;

public class ArrayListDemo {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		List<Integer> linkedList = new LinkedList<Integer>();
		List<Integer> list1 = new CopyOnWriteArrayList<>();
		Stack stack = new Stack();
		
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		
		
		Iterator<Integer> iterator = list.iterator();
		while(iterator.hasNext()){
			Integer val = iterator.next();
			if(val == 3){
				list.set(1, 10);
			}
			if(val == 2)
				list.remove(1);
			if(val == 2)
				list.add(11);
			System.out.println(val);
		}
		
		System.out.println("-----------After-----------");
		
		list.forEach( e -> System.out.println(e));
		
	}

}
