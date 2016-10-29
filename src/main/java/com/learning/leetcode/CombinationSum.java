package com.learning.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class CombinationSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] comb = {1,2,4,5};
		
		System.out.println(combinationSum(comb,5));
	}
	
	public static ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
	    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	 
	    if(candidates == null || candidates.length == 0) return result;
	 
	    ArrayList<Integer> current = new ArrayList<Integer>();
	    Arrays.sort(candidates);
	 
	    combinationSum(candidates, target, 0, current, result);
	 
	    return result;
	}
	 
	public static void combinationSum(int[] candidates, int target, int j, ArrayList<Integer> curr, ArrayList<ArrayList<Integer>> result){
	   if(target == 0){
	       ArrayList<Integer> temp = new ArrayList<Integer>(curr);
	       result.add(temp);
	       return;
	   }
	 
	   for(int i=j; i<candidates.length; i++){
	       if(target < candidates[i]) 
	            return;
	 
	       curr.add(candidates[i]);
	       combinationSum(candidates, target - candidates[i], i, curr, result);
	       curr.remove(curr.size()-1); 
	   }
	}

}
