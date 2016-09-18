package com.learning.search;

import java.util.Scanner;

public class BinarySearch {
	
	private static boolean binarySearch(int[] arr, int num, int start, int end) {
		// TODO Auto-generated method stub
		if(arr==null || arr.length==0){
			return false;
		}
		int mid;
		
		while(start<=end){
			
			mid= start+ (end-start)/2;
			
			if(arr[mid]==num){
				return true;
			}
			else if(num < arr[mid]){
				end=mid-1;
			}
			else{
				start=mid+1;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = {2,4,6,8,9,12};
		System.out.println("Enter number to be searched:\n");
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		
		System.out.println("Number is "+num);
		
		if(binarySearch(arr, num , 0 , arr.length-1)){
			System.out.println("Number is present");
		}
		else{
			System.out.println("Number is not present");
		}
		
	}

	

}
