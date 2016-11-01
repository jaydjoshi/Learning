package com.learning.thread.multithreading;

public class StaticMehodDemo {

	public static void main(String[] args) {

		Employee emp = new Employee();
		Thread thread1 =  new Thread(() -> { 
			long start = System.currentTimeMillis();
			System.out.println("Started 1 at "+start);
			int percent = Employee.getPfPercentage();
			System.out.println("Percent : "+percent);
			long end = System.currentTimeMillis();
			System.out.println("End 1 in "+(end-start));
		}) ;
		
		Thread thread4 =  new Thread(() -> { 
			long start = System.currentTimeMillis();
			System.out.println("Started 4 at "+start);
			int percent = Employee.getPfPercentage();
			System.out.println("Percent : "+percent);
			long end = System.currentTimeMillis();
			System.out.println("End 4 in "+(end-start));
		}) ;
		
		Thread thread2 =  new Thread(() -> { 
			long start = System.currentTimeMillis();
			System.out.println("Started 2 at "+start);
			int percent = emp.getCount();
			System.out.println("Count : "+percent);
			long end = System.currentTimeMillis();
			System.out.println("End 2 in "+(end-start));
		}) ;
		
		Thread thread3 =  new Thread(() -> { 
			long start = System.currentTimeMillis();
			System.out.println("Started 3 at "+start);
			int percent = emp.getCount1();
			System.out.println("Count : "+percent);
			long end = System.currentTimeMillis();
			System.out.println("End 3 in "+(end-start));
		}) ;
		
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
	}

}


class Employee {
	
	public static int pfPercent =12;
	private int count=0;
	static Object mutex1 = new Object();
	Object mutex2 = new Object();
	Object mutex3 = new Object();
	
	public static int getPfPercentage(){
		synchronized(mutex1){
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pfPercent;
		}
	}
	
	public  int getCount(){
		
		synchronized(mutex2){
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count++;
		}
		
	}
	
	public  int getCount1(){
		
		synchronized(mutex3){
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count++;
		}
		
	}

}