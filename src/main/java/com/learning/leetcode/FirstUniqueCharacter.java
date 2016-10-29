package com.learning.leetcode;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

/**
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
 *
 */
public class FirstUniqueCharacter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(firstUniqChar("loveleetcode"));
		System.out.println(firstUniqChar("leetcode"));
		System.out.println(firstUniqChar("dddccdbba"));
		System.out.println(firstUniqChar("cc"));
		
		
	}

	public static int firstUniqChar(String s) {
		
		
		char[] arr = s.toCharArray();
		LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
		for (char c : arr) {
			if(map.containsKey(c)){
				int count = map.get(c);
				map.put(c, ++count);
			}
			else
				map.put(c, 1);
		}
		int result=0;
		Character res = null;
		for (Entry<Character, Integer> i : map.entrySet()) {
			result++;
			if(i.getValue()==1){
				res = new Character(i.getKey());
				break;
			}
		}
		if(res==null)
			return -1;
		for (int i = 0; i < arr.length; i++) {
			if(res==arr[i])
				return i;
		}
		return -1;
	}

}
