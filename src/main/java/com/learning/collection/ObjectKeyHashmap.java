package com.learning.collection;

import java.util.HashMap;

public class ObjectKeyHashmap {

	public static void main(String[] args) {
		HashMap<Employee, Integer> map = new HashMap<>();
		
		Employee e1 = new Employee(1, "Jay");
		Employee e2 = new Employee(2, "Rohan");
		map.put(e1, 1);
		map.put(e2, 2);
		map.put(e1, 3);
		
		/*e2.setName("Rohan Joshi");
		e2.setId(5);*/
		
		map.forEach( (k,v) -> System.out.println("Key "+ k.getId() +" - "+k.getName() + " Value "+v));
		System.out.println(map.get(new Employee(2,"Rohan")));
	}

}


