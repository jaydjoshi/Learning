package com.learning.leetcode;

/**
 * Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.
 * Example:
 * Given a = 1 and b = 2, return 3.
 * 
 */
public class AddTwoIntegers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Sum : "+ getSum(2, 3) );
		System.out.println("Sum : "+ getSum(15, 20) );
	}
	
	public static int getSum(int x,int y){
		// Iterate till there is no carry  
	    while (y != 0)
	    {
	        // carry now contains common set bits of x and y
	        int carry = x & y;  
	 
	        // Sum of bits of x and y where at least one of the bits is not set
	        x = x ^ y; 
	 
	        // Carry is shifted by one so that adding it to x gives the required sum
	        y = carry << 1;
	    }
	    return x;
	}

}
