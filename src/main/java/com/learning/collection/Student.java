package com.learning.collection;

import java.util.ArrayList;
import java.util.List;

public final class Student implements Cloneable{
	
	private final int rollNo;
	private final String name;
	private final List<String> friends;
	
	public Student(int rollNo , String name , List<String> friends) {
		this.rollNo=rollNo;
		this.name= name;
		this.friends = new ArrayList<>();
		friends.forEach( k -> this.friends.add(k));
		//this.friends = friends;
	}
	
	/**
	 * @return the rollNo
	 */
	public int getRollNo() {
		return rollNo;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the friends
	 */
	public List<String> getFriends() {
		if(friends != null){
			List<String> newFriends = new ArrayList<>();
			
			friends.forEach( k -> newFriends.add(k));
			
			//return (List<Student>) friends.clone();
			return newFriends;
		}
		return new ArrayList<>();
		
	}
	

}

