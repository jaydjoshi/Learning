package com.learning.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class ConcurrentMapDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Map<String,Integer> map = new ConcurrentHashMap<>();
		//Map<String,Integer> map = new LinkedHashMap<>();
		//Map<String,Integer> map = new TreeMap<>();
		map.put("jay", 1);
		map.put("yaj", 2);
		map.put("ajy", 3);
		
		List<Integer> list = new CopyOnWriteArrayList<>();
		
		
		/*for (Entry entry : map.entrySet()) {
			
			System.out.println(entry.getKey()+" - "+entry.getValue());
			map.remove("jay");
		}*/
		
		//map.forEach( (k,v)-> System.out.println("Key: " + k + ": Value: " + v));
		
		Iterator iterator = map.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry object = (Entry) iterator.next();
			System.out.println(object.getKey()+" - "+object.getValue());
			if(object.getKey().equals("jay"))
			iterator.remove();
			//map.remove("jay");
			//map.put("A", 4);
		}
		
		map.forEach( (k,v)-> System.out.println("Key: " + k + ": Value: " + v));

	}

}
