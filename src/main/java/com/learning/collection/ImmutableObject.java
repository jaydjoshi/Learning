package com.learning.collection;

import java.util.ArrayList;
import java.util.List;

public class ImmutableObject {

	public static void main(String[] args) {
		
		List<String> friends1 = new ArrayList<>();
		List<String> friends2 = new ArrayList<>();
		
		friends1.add("1");
		friends1.add("2");
		
		friends2.add("3");
		
		Student student1 = new Student(1, "Rohan", friends1);
		Student student2 = new Student(2, "Ashish", friends1);
		Student student3 = new Student(3, "Sonu" , friends2);
		
		
		
		
		
		//hacking wont work
		friends2.add("2");
		
		//hacking wont work now
		student3.getFriends().add("2");
		student3.getFriends().add("3");
		
		System.out.println(student1.getRollNo()+ " "+ student1.getFriends().size());
		System.out.println(student2.getRollNo()+ " "+ student2.getFriends().size());
		System.out.println(student3.getRollNo()+ " "+  student3.getFriends().size() );
	}

}

