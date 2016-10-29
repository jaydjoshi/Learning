package com.learning.leetcode;

public class LongestPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("String : "+longestPalindrome("ababa")+" \nlength : "+longestPalindrome("ababa").length());
		System.out.println("String : "+longestPalindrome("ababaa")+" \nlength : "+longestPalindrome("ababaa").length());
		System.out.println("String : "+longestPalindrome("vababaa")+" \nlength : "+longestPalindrome("vababaa").length());
		System.out.println("String : "+longestPalindrome("daaba")+" \nlength : "+longestPalindrome("daaba").length());

	}
	
	public static boolean palindrome(String str){
		StringBuffer reverse = new StringBuffer(str).reverse();
		if(str.equals(reverse.toString()))
			return true;
		
		return false;
	}
	
	public static String longestPalindrome(String str){
		
		int l = str.length();
		
		if(l<2)
			return str;
		
		int start=0,end=l;
		
		while(start<=end){
			if(palindrome(str.substring(start,end))){
				return str.substring(start, end);
			}
			else{
				if(palindrome(str.substring(start+1,end))){
					start++;
					return str.substring(start, end);
				}
				else if(palindrome(str.substring(start,end-1))){
					end--;
					return str.substring(start, end);
				}
				else{
					start++;
					end--;
				}
			}
		}
		return null;
		
	}
	

}
