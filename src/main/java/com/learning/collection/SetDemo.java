package com.learning.collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class SetDemo {
	
	
	
	public ConcurrentHashMap<String,Object> con = new ConcurrentHashMap<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Set<String> linkedList = new LinkedHashSet<String>();
		 ///List<String> linkedList = new ArrayList<>();
		 //List<String> linkedList = new LinkedList<>();
		
		
		
		//linkedList.add("A");
		
		//set.add(null);
		linkedList.add("A");
		linkedList.add("B");
		linkedList.add("C");
		linkedList.add("D");
		
		/*Iterator<String> iterator = set.iterator();
		while(iterator.hasNext()){
			String temp = (String) iterator.next();
			System.out.println(temp);
		}*/
		
		Iterator<String> iterator = linkedList.iterator();
		while (iterator.hasNext()) {
			String string = (String) iterator.next();
			System.out.println(string);
			
		}
		
		/*for (String string : set) {
			System.out.println(string);
		}*/

	}

}
