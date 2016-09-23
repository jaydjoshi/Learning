package com.learning.leetcode;

public class IntegerToRoman {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(intToRoman(58));
		System.out.println(intToRoman(5));
		System.out.println(intToRoman(18));
		System.out.println(intToRoman(23));
		System.out.println(intToRoman(108));
		System.out.println(intToRoman(99));

		System.out.println(intToRoman(258));
		System.out.println(intToRoman(591));
		System.out.println(intToRoman(128));
		System.out.println(intToRoman(22323));
		System.out.println(intToRoman(199));
		System.out.println(intToRoman(500));
		
	}
	
	public static String intToRoman(int n){
		int[] numDict = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
		String[] romanDict = {"C","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
		StringBuffer sb = new StringBuffer();
		int i=0;
		if(n>3999){
			return "System does not support this nummber ";
		}
		while(n>0 && i<=romanDict.length){
			if(n>=numDict[i]){
				n=n-numDict[i];
				sb.append(romanDict[i]);
			}
			else{
				i++;
			}
		}
		
		return String.valueOf(sb);
	}

}
