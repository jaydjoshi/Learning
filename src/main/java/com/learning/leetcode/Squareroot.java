package com.learning.leetcode;

public class Squareroot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(squareRoot(25));
		System.out.println(squareRoot(100));
		System.out.println(squareRoot(90));
		System.out.println(squareRoot(-144));

	}
	
	public static int squareRoot(int num){
		
		boolean negativeNum = false;
		if(num==0 || num==1)
			return num;
		
		if(num<0){
			negativeNum= true;
			num=-num;
		}
		
		int mid = 0,squareRoot = 0,start = 0,end=num;
		
		while(start<=end ){
			
			mid = start + (end-start)/2;
			
			if(mid*mid <= num && (mid+1)*(mid+1) > num){
				squareRoot = mid;
				break;
			}
			else if(mid*mid < num){
				start=mid;
			}
			else {
				end = mid;
			}
		
		}	
		
		if(negativeNum)
			return -squareRoot;
		else
			return squareRoot;
		
	}

}
