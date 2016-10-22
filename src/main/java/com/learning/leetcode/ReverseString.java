package com.learning.leetcode;

public class ReverseString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverseString("Hello"));

	}

	public static String reverseString(String s) {

		StringBuffer sb = new StringBuffer(s);
		String reverse = sb.reverse().toString();
		return reverse;

	}

}
