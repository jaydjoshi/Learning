package com.learning.search;

import java.util.Scanner;

public class LinearSearch {
	
	public static boolean linearSearch(int[] arr, int num) {
		// TODO Auto-generated method stub
		
		if(arr==null || arr.length==0){
			return false;
		}
		int len= arr.length;
		
		for (int i = 0; i < len; i++) {
			if(arr[i]==num){
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = {2,7,4,9,36,3,0,24,65,6};
		System.out.println("Enter number to be searched:\n");
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		
		System.out.println("Number is "+num);
		
		if(linearSearch(arr,num)){
			System.out.println("Number is present");
		}
		else{
			System.out.println("Number is not present");
		}

	}

	

}
