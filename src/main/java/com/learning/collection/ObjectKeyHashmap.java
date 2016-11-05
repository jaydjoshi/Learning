package com.learning.collection;

import java.util.HashMap;

public class ObjectKeyHashmap {

	public static void main(String[] args) {
		HashMap<Employee, Integer> map = new HashMap<>();
		
		map.put(new Employee(1, "Jay"), 1);
		map.put(new Employee(2, "Rohan"), 2);
		map.put(new Employee(1, "Jay"), 3);
		
		map.forEach( (k,v) -> System.out.println("Key "+ k.getId() + " Value "+v));
	}

}


class Employee{
	private int id;
	private String name;
	
	public Employee(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	public int hashCode(){
		return id;
	}
	
	public boolean equals(Object object){
		if(object == this){
			return true;
		}
		
		if(object instanceof Employee && object != null){
			return ((Employee)object).getId() == id ? true : false;
		}
		
		return false;
	}
}