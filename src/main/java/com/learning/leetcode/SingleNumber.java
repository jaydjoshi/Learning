package com.learning.leetcode;

/**
 *
 *	Given an array of integers, every element appears twice except for one. Find that single one.
 *	Note:
 *	Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory
 *
 */

/*
 * Use XOR operator to solve this problem in O(n) i.e. linear time
 */
public class SingleNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,1,2,3,5,6,4,2,5,6,3};
		System.out.println(singleNumber(arr));
	}
	
	public static int singleNumber(int[] nums) {
        int result=0;
        for(int i =0; i<nums.length ; i++){
            result = result ^ nums[i];
        }
        return result;
    }

}
