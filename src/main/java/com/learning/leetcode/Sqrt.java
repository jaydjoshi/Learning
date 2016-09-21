package com.learning.leetcode;

/**
 * Get the square root of number using the binary search method.
 * @author jdhirendrajoshi
 *
 */
public class Sqrt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] numArr = {1,9, 25, 90, 100, 400};
		
		for (int i = 0; i < numArr.length; i++) {
			System.out.println("Result: "+ sqrt(numArr[i]));
		}
	}
	
	public static int sqrt(int n){
		if(n<=0)
			return 0;
		if(n==1)
			return 1;
		
		int left = 0,right = n,mid;
		
		while(left<=right){ //consider equal
			mid=left+(right-left)/2;
			
			if(mid == n/mid)
				return mid;
			else if(mid > n/mid)
				right=mid-1;
			else
				left=mid+1;
		}
		
		return right;
		
	}

}
