package com.learning.leetcode;

public class MoveZero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr ={1,2,0,7,0};
		moveZeroes(arr);
		for (int i : arr) {
			System.out.println(i);
		}
	}
	
	 public static void moveZeroes(int[] nums) {
	        int temp=0;
	        for(int i=0; i<nums.length ; i++){
	            if(nums[i]==0){
	                //swap with next non zero element
	                int j=i+1;
	                while(j<nums.length && nums[j]==0){
	                    j++;
	                }
	                if(j<nums.length){
		                temp = nums[j];
		                nums[j] = nums[i];
		                nums[i] = temp;
	                }
	            }
	        }
	        
	    }

}
