package com.learning.collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

public class SetDemo {
	
	
	
	public ConcurrentHashMap<String,Object> con = new ConcurrentHashMap<>();
	public static void main(String[] args) {
		Set<String> hashset = new HashSet<String>();
		Set<String> linkedset = new LinkedHashSet<String>();
		Set<String> treeset = new TreeSet<String>();
		Set<String> copyset = new CopyOnWriteArraySet<String>();
		
		
		
		
		//linkedList.add("A");
		
		//set.add(null);
		linkedset.add("A");
		linkedset.add("B");
		linkedset.add("C");
		linkedset.add("D");
		
		/*Iterator<String> iterator = set.iterator();
		while(iterator.hasNext()){
			String temp = (String) iterator.next();
			System.out.println(temp);
		}*/
		
		Iterator<String> iterator = linkedset.iterator();
		while (iterator.hasNext()) {
			String string = (String) iterator.next();
			System.out.println(string);
			
		}
		
		/*for (String string : set) {
			System.out.println(string);
		}*/

	}

}
