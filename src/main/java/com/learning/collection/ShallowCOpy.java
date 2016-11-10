package com.learning.collection;

import java.util.AbstractList;
import java.util.ArrayList;

public class ShallowCOpy {

	public static void main(String[] args) throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		ArrayList<Person> list = new ArrayList<>();
		Person p1 = new Person("Jay");
		Person p2 = new Person("Bhavin");
		Person p3 = new Person("Amar");
		list.add(p1);
		list.add(p2);
		list.add(p3);
		
		//shallow
		ArrayList<Person> copy = (ArrayList<Person>) list.clone();
		
		//deep
		/*ArrayList<Person> copy = new ArrayList<>();
		for (Person person : list) {
			copy.add(new Person(person.getName()));
		}*/
		
		String str = new String("Jay");
		
		
		p1.setName("Jay Joshi");
		list.forEach( (e) -> System.out.println(e.getName()));
		System.out.println("--------------");
		list.forEach( (e) -> System.out.println(e.getName()));
		System.out.println("--------------");
		copy.forEach( (e) -> System.out.println(e.getName()));
		System.out.println("--------------");
		
		
	}

}


class Person implements Cloneable{
	private String name;
	
	public Person(String name) {
		this.name=name;
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
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	
}