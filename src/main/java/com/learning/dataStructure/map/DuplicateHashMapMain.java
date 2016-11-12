package com.learning.dataStructure.map;

public class DuplicateHashMapMain {

	public static void main(String[] args) {
		DuplicateHashmap<String, Integer> map = new DuplicateHashmap<>();
		
		map.put("Jay", 97);
		map.put("Ajy", 97);
		map.put("Rohan", 95);
		map.put("Madari", 90);
		map.put("jay", 1);
		map.put("yaj", 2);
		map.put("ajy", 3);
		
		System.out.println(map.get("Jay"));
		System.out.println(map.get("Jay Joshi"));
		System.out.println(map.get("Rohan"));
		System.out.println(map.get("Ajy"));
		map.remove("Ajy");
		System.out.println(map.get("Ajy"));
		
		
	}

}
