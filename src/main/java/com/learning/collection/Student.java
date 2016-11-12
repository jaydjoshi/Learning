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

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((friends == null) ? 0 : friends.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + rollNo;
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (friends == null) {
			if (other.friends != null)
				return false;
		} else if (!friends.equals(other.friends))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (rollNo != other.rollNo)
			return false;
		return true;
	}
	
	
	

}

