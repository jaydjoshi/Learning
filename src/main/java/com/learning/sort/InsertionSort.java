package com.learning.sort;

public class InsertionSort {
	
	public static int[] insertionSort(int[] arr){
		
		if(arr== null || arr.length==0){
			return null;
		}
		
		int length = arr.length;
		int value;
		int hole;
		
		for (int i = 1; i < length; i++) {
			value=arr[i];
			hole=i;
			while(hole>0 && arr[hole-1]>value){
				arr[hole]=arr[hole-1];
				hole--;
			}
			arr[hole]=value;
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
		int[] sortedArr = insertionSort(arr);
		
		System.out.println("\nAfter ");
		for (int i : sortedArr) {
			System.out.print(i+" ");
		}


	}

}
