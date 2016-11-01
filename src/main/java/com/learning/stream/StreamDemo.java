package com.learning.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StreamDemo {

	public static void main(String[] args) {
		//List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < 10000; i++) {
			list.add(i);
		}
		long start = System.currentTimeMillis();
		System.out.println("Started : "+start);
		System.out.println();
		System.out.println("---Even---");
		printAllOddEven(true, list);
		System.out.println("---Odd---");
		printAllOddEven(false, list);
		
		long end = System.currentTimeMillis();
		System.out.println("Time taken: "+(end-start));
		
		list = new ArrayList<>();
		for (int i = 0; i < 1000; i++) {
			list.add((new Random()).nextInt(1000));
		}
		
		sumOfDigits(list);
		
	}
	
	public static void printAllOddEven(boolean even , List<Integer> list){
		
		if(even)
			list.stream()
			.filter( i -> i%2 ==0 )
			.forEach( i -> System.out.println(i));
		
		else
			list.stream()
			.filter( i -> i%2 !=0 )
			.forEach( i -> System.out.println(i));
	}
	
	public static void sumOfDigits(List<Integer> num){
		
		num.stream().sorted().forEach( i -> System.out.println(i));
		return ;
		
	}

}
