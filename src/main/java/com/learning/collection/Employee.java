package com.learning.collection;

public class Employee {
	private final int id;
	private final String name;
	
	public Employee(int id, String name) {
		this.id=id;
		this.name=name;
	}
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	
	public int hashCode(){
		return id;
	}
	
	public boolean equals(Object object){
		if(object == this){
			return true;
		}
		
		if(object instanceof Employee && object != null){
			return ((Employee)object).getId() == id  && name.equals(((Employee)object).getName()) ? true : false;
		}
		
		return false;
	}
}
