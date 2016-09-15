package com.learning.sort;

public class SelectionSort {
	

	public static int[] selectionSort(int[] arr){
		
		
		if(arr == null || arr.length==0){
			System.out.println("Invalid input");
			return null;
		}
		
		int length = arr.length;
		for (int i = 0; i < length-1; i++) {
		
			//find min
			int min = arr[i];
			int pos=i;
			for (int j = i; j < length; j++) {
				
				if(arr[j]<min){
					min=arr[j];
					pos=j;
				}
			}
			
			//swap
			
			arr[pos]=arr[i];
			arr[i]= min;
			
		}
		
		return arr;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("start");
		int[] arr= {7,2,5,3,10,4,6,3,6,0,5,29,23,8,-2,8,90,45,17};
		
		System.out.println("Before ");
		for (int i : arr) {
			System.out.print(i+" ");
		}
		System.out.println();
		int[] sortedArr = selectionSort(arr);
		
		System.out.println("\nAfter ");
		for (int i : sortedArr) {
			System.out.print(i+" ");
		}

	}

}
