package com.learning.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.

This is case sensitive, for example "Aa" is not considered a palindrome here.

Note:
Assume the length of given string will not exceed 1,010.
 *
 */
public class LongestPalindromeLength {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(longestPalindrome("abccccdd"));
		System.out.println(longestPalindrome("aa"));
	}
	
	public static int longestPalindrome(String s) {
		
		if(s==null)
			return 0;
		else if(s.length()>1010)
			return 0;
		
		char[] charArr = s.toCharArray();
		Map<Character,Integer> map = new HashMap<>();
		for (char c : charArr) {
			if(map.containsKey(c)){
				int count = map.get(c);
				map.put(c, ++count);
			}
			else 
				map.put(c, 1);
		}
		
		int result=0;
		boolean temp = false;
		for (Entry<Character, Integer> c : map.entrySet()) {
			if(c.getValue()!=1)
				result+=c.getValue();
			else
				temp=true;
		}
		
		if(temp)
			return result%2!=0? result : result+1;
		else
			return result;
        
    }

}
