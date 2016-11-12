package com.learning.collection;

public class StringDemo {

	public static void main(String[] args) {
		String s1 = "hello";
		String s2 = "hello";
		String s3 = new String("hello").intern();
		
		System.out.println(s1 == s1);
		System.out.println(s1 == s2);
		System.out.println(s1 == s3);
		
		System.out.println(s1.equals(s2));
		System.out.println(s1.equals(s3));
		System.out.println("------------------");
		String newString = "Helloasdfghjklhellowlkjhhello";
		System.out.println(newString.substring(2,5));
		System.out.println(newString.substring(29));
		System.out.println("------------------");
		//System.out.println(newString.substring(50));
	}

}
