package com.learning.leetcode;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Example 1:
Input: [7, 1, 5, 3, 6, 4]
Output: 5

max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)
Example 2:
Input: [7, 6, 4, 3, 1]
Output: 0

In this case, no transaction is done, i.e. max profit = 0.
 */
public class BuyAndSellStocks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {7, 1, 5, 3, 6, 4};
		System.out.println(maxProfit(arr));
		int[] arr2 = {7, 6, 4, 3, 1};
		System.out.println(maxProfit(arr2));
		int[] arr1 = {2,4,1};
		System.out.println(maxProfit(arr1));
	}

	public static int maxProfit(int[] prices) {
	    if(prices==null||prices.length<=1)
	        return 0;
	 
	    int min=prices[0]; // min so far
	    int result=0;
	 
	    for(int i=1; i<prices.length; i++){
	        result = Math.max(result, prices[i]-min);
	        min = Math.min(min, prices[i]);
	    }
	 
	    return result;
}

}
