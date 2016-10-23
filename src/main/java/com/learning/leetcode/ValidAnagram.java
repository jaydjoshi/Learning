package com.learning.leetcode;

import java.util.HashSet;

/**
 * Given two strings s and t, write a function to determine if t is an anagram
 * of s.
 * 
 * For example, s = "anagram", t = "nagaram", return true. s = "rat", t = "car",
 * return false.
 * 
 * Note: You may assume the string contains only lowercase alphabets.
 *
 */
public class ValidAnagram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isAnagram("anagram", "nagaram"));
		System.out.println(isAnagram("rat", "car"));
	}

	public static boolean isAnagram(String s, String t) {
		char[] sArr = s.toCharArray();
		char[] tArr = t.toCharArray();
		HashSet<Character> set = new HashSet<>();
		
		if(sArr.length!=tArr.length)
			return false;
		
		for (int i = 0; i < sArr.length; i++) {
			set.add(sArr[i]);
		}
		for (int i = 0; i < tArr.length; i++) {
			set.remove(tArr[i]);
		}
		if(set.size()==0)
			return true;
		
		return false;

	}

}
