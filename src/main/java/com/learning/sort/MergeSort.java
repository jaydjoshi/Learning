package com.learning.sort;

import java.util.Arrays;

public class MergeSort {
	
	/**
	 * merge two sorted arrays into a single merged array
	 * @param left
	 * @param right
	 * @param arr
	 * @return integer array
	 */
	public static int[] merge(int[] left, int[] right, int[] arr){
		
		int i=0,j=0,k=0;
		int lLength=left.length;
		int rLength=right.length;
		
		
		while(i<lLength && j<rLength){
			if(left[i]<right[j]){
				arr[k]=left[i];
				k++;
				i++;
			}
			else{
				arr[k]=right[j];
				k++;
				j++;
			}
		}
		
		//merge remianing elements 
		while(i<lLength){
			arr[k]=left[i];
			k++;
			i++;
		}
		while(j<rLength){
			arr[k]=right[j];
			k++;
			j++;
		}
		return arr;
	}
	
	
	public static int[] mergeSort(int[] arr){
		
		if(arr==null || arr.length==0){
			return null;
		}
		//exit condition for recurrsion
		else if(arr.length<2){
			return arr;
		}
		
		int length = arr.length;
		int mid = length/2;
		
		int[] left = Arrays.copyOfRange(arr, 0, mid);
		int[] right = Arrays.copyOfRange(arr, mid, length);
		
		mergeSort(left);
		mergeSort(right);
		merge(left, right, arr);
		
		//memory optimization
		left=null;
		right=null;
		System.gc();
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
		int[] sortedArr = mergeSort(arr);
		
		System.out.println("\nAfter ");
		for (int i : sortedArr) {
			System.out.print(i+" ");
		}


	}

}
