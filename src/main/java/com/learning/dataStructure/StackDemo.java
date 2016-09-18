package com.learning.dataStructure;

import java.util.Map;
import java.util.TreeMap;

public class StackDemo {
	
	static Map obj = new TreeMap();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack stack1 = new Stack();
		
		System.out.println(obj.toString());
		
		stack1.push(10);
		stack1.push(20);
		stack1.push(30);
		stack1.push(40);
		stack1.push(50);
		stack1.push(60);
		stack1.push(70);
		stack1.push(80);
		stack1.push(90);
		stack1.push(10);
		stack1.push(11);
		stack1.push(12);
		
		System.out.println("top before"+stack1.top());
		
		while(!stack1.isEmpty()){
			System.out.println(stack1.pop());
		}
		
		System.out.println("top after"+stack1.top());
	}

}

