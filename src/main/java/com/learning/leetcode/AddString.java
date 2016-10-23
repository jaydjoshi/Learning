package com.learning.leetcode;

public class AddString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(addStrings("191325924", "211103343"));
		
	}

	public static String addStrings(String num1, String num2) {
		
		char[] num1Arr = num1.toCharArray();
		char[] num2Arr = num2.toCharArray();
		
		int length1 = num1Arr.length;
		int length2 = num2Arr.length;
		char[] result = new char[length1+1];
		int carry = 0;
		if(length1==length2)
		for (int i = length1-1; i >= 0; i--) {
			int temp = (Character.getNumericValue(num1Arr[i])+ Character.getNumericValue(num2Arr[i]) + carry);
			if(temp/10!=0){
				result[i+1]=Character.forDigit(temp%10, 10);
				carry=temp/10;
			}
			else{
				result[i+1]=Character.forDigit(temp, 10);
				carry=0;
			}
		}
		return String.valueOf(result);
		
	}

}
