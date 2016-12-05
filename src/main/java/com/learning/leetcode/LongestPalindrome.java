package com.learning.leetcode;

public class LongestPalindrome {

	public static void main(String[] args) {
		System.out.println("String : "+longestPalindrome("ababa")+" \nlength : "+longestPalindrome("ababa").length());
		System.out.println("String : "+longestPalindrome("ababaa")+" \nlength : "+longestPalindrome("ababaa").length());
		System.out.println("String : "+longestPalindrome("vababaa")+" \nlength : "+longestPalindrome("vababaa").length());
		System.out.println("String : "+longestPalindrome("daaba")+" \nlength : "+longestPalindrome("daaba").length());
		
		System.out.println("**********************************************************************************");
		
		System.out.println("String : "+ManchersAlgo("ababa"));
		System.out.println("String : "+ManchersAlgo("ababaa"));
		System.out.println("String : "+ManchersAlgo("vababaa"));
		System.out.println("String : "+ManchersAlgo("daaba"));
		System.out.println("String : "+ManchersAlgo("daabba"));

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
	
	public static int ManchersAlgo(String str){
		char[] charArr = str.toCharArray();
		int[] intArr = new int[charArr.length];
		
		for (int i = 0; i < charArr.length; i++) {
			char c = charArr[i];
			intArr[i] = checkMaxPalindromeAround(c,charArr,i);
		}
		
		int maxLength = checkMaxLength(intArr);
		return maxLength;
	}

	private static int checkMaxLength(int[] intArr) {
		int max = intArr[0];
		for (int i = 0; i < intArr.length; i++) {
			if(max<intArr[i])
				max=intArr[i];
		}
		return max;
	}

	private static int checkMaxPalindromeAround(char c,char[] charArr, int index) {
		int start=index,end =index;
		int length=1;
		start--;
		end++;
		while(start>=0 && end <= charArr.length-1){
			
			if(!(charArr[start]==charArr[end])){
				break;
			}
			else{
				length=length + 2;
				start--;
				end++;
			}
		}
		return length;
	}
	

}
