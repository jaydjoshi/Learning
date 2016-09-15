package com.learning.sort;

public class QucikSort {
	
	private static int partition(int[] arr, int start, int end) {
		// TODO Auto-generated method stub
		int iPartition =start;
		int pivot = arr[end];
		
		int temp;
		
		for (int i = start; i < end; i++) {
			if (arr[i] <= pivot) {
				//swap
				temp=arr[i];
				arr[i]=arr[iPartition];
				arr[iPartition]=temp;
				iPartition++;
			}
		}
		//swap last element with iPartition index
		temp=arr[iPartition];
		arr[iPartition]=arr[end];
		arr[end]=temp;
		
		return iPartition;
		
	}	
	
	public static int[] quickSort(int[] arr, int start, int end){
		if(arr==null || arr.length==0){
			return null;
		}
		if(start < end){
			int pivot = partition(arr,start,end);
			
			quickSort(arr, start, pivot-1);
			quickSort(arr, pivot+1, end);
			
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
		int[] sortedArr = quickSort(arr,0,arr.length-1);
		
		System.out.println("\nAfter ");
		for (int i : sortedArr) {
			System.out.print(i+" ");
		}


	}

}
