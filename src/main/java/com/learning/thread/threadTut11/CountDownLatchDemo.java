package com.learning.thread.threadTut11;

public class CountDownLatchDemo {

	public static void main(String[] args) {
		AmusementPark park = new AmusementPark();
		
		System.out.println("Start");
		
		Thread t1 = new Thread(park);
		Thread t2 = new Thread(park);
		Thread t3 = new Thread(park);
		
		t1.start();
		t2.start();
		t3.start();
		
		System.out.println("End");
		
	}

}
