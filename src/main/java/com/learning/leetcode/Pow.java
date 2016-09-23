package com.learning.leetcode;

public class Pow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(pow(10,3));
		System.out.println(pow(5,3));
		System.out.println(pow(10,5));
		System.out.println(pow(100,1));
		System.out.println(pow(100,2));
	}
	
	public static int pow(int num,int power){
		
		int result=1;
		for (int i = 1; i <= power; i++) {
			result=result*num;
		}
		return result;
	}

}
