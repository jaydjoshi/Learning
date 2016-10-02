package com.learning.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class MapDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Map<String,Integer> map = new HashMap<>();
		//Map<String,Integer> map = new LinkedHashMap<>();
		Map<String,Integer> map = new TreeMap<>();
		map.put("jay", 1);
		map.put("yaj", 2);
		map.put("ajy", 3);
		map.put(null, 2);
		
		
		
		/*for (Entry entry : map.entrySet()) {
			
			System.out.println(entry.getKey()+" - "+entry.getValue());
			map.remove("jay");
		}*/
		
		map.forEach( (k,v)-> System.out.println("Key: " + k + ": Value: " + v));
		
		/*Iterator iterator = map.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry object = (Entry) iterator.next();
			System.out.println(object.getKey()+" - "+object.getValue());
			map.remove("jay");
		}*/

	}

}
