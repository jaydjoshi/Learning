package com.learning.sort;

public class BubbleSort {
	
	public static int[] bubbleSort(int[] arr){
		
		if(arr==null || arr.length==0){
			return null;
		}
		
		int length = arr.length;
		int temp;
		for (int i = 0; i < length-1; i++) {
			int flag=0;
			for (int j = 0; j < length-1-i; j++) {
				if(arr[j]>arr[j+1]){
					temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
					flag=1;
				}
			}
			if(flag==0)
				break;
			
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
		int[] sortedArr = bubbleSort(arr);
		
		System.out.println("\nAfter ");
		for (int i : sortedArr) {
			System.out.print(i+" ");
		}


	}

}
