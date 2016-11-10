package com.learning.dataStructure.stack;

import java.util.Map;
import java.util.TreeMap;

public class Stack{
	//need methods push, pop, top 
	
	private int INITIAL_CAPACITY = 10;
	private Object[] stackArr;
	private int top;
	
	
	
	
	public Stack() {
		// TODO Auto-generated constructor stub
		stackArr = new Object[INITIAL_CAPACITY];
		top = -1;
	}
	
	public Object push(Object num){
		if(top==INITIAL_CAPACITY-1){
			increaceCapacity();
		}
		return stackArr[++top]= num;
	}
	
	private void increaceCapacity() {
		// TODO Auto-generated method stub
		int NEW_CAPACITY = INITIAL_CAPACITY*2;
		
		Object[] temp= new Object[NEW_CAPACITY];
		
		System.arraycopy(stackArr, 0, temp, 0, INITIAL_CAPACITY);
		stackArr=temp;
		
		INITIAL_CAPACITY = NEW_CAPACITY;
		
		
	}

	public Object pop(){
		
		return stackArr[top--];
	}
	
	public int top(){
		return top;
	}
	
	public boolean isEmpty(){
		
		if(top<0)
			return true;
		else
			return false;
		
	}
}
