package com.learning.leetcode;

public class Palindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [] numArr = {1,9, 25, 9089, 109, 415,919};
		
		for (int i = 0; i < numArr.length; i++) {
			int reverse = Reverse.reverse(numArr[i]);
			if(numArr[i]==reverse){
				System.out.println("Number "+numArr[i] +" is palindrome");
			}
			else{
				System.out.println("Number "+numArr[i] +" is not palindrome");
			}
			
		}

	}

}
