package com.learning.leetcode;

import java.util.HashMap;


/**
 * Given two strings s and t which consist of only lowercase letters.

	String t is generated by random shuffling string s and then add one more letter at a random position.

 *
 */
public class FindTheDifference {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findTheDifference("abcdef", "abckdef"));
	}
	
	public static char findTheDifference(String s, String t) {
        char result = 0 ;
        HashMap<Character,Integer> list = new HashMap<>();
        char[] sC = s.toCharArray();
        char[] tC = t.toCharArray();
        for (int j = 0; j < tC.length; j++) {
			list.put(tC[j],1);
		}
        for (int j = 0; j < sC.length; j++) {
			list.remove(sC[j]);
		}
        if(list.size()==1){
        	for (char c : list.keySet()) {
				result=c;
			}
        }
        return result;
    }

}