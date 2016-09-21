package com.learning.leetcode;

public class Reverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [] numArr = {1,9, 25, 9089, 109, 415};
		
		for (int i = 0; i < numArr.length; i++) {
			System.out.println("Result: "+ reverse(numArr[i]));
		}

	}
	
	public static int reverse(int num){
		
		int mod;
		long result = 0;
		
		
		while(num>0){
			mod=num%10;
			result=result*10+mod;
			num=num/10;
		}
		
		if(Integer.MAX_VALUE<result && Integer.MIN_VALUE>result)
			return 0;
		
		return (int)result;
	}

}
