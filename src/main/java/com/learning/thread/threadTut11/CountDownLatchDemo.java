package com.learning.thread.threadTut11;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {

	public static void main(String[] args) {
		CountDownLatch latch = new CountDownLatch(4);
		AmusementPark park = new AmusementPark(latch);
		
		System.out.println("Amusment park started");
		
		Thread t1 = new Thread(park,"Person1");
		Thread t2 = new Thread(park,"Person2");
		Thread t3 = new Thread(park,"Person3");
		Thread t4 = new Thread(park,"Person4");
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Ride started. :)");
		
		System.out.println("Amusment park stopped");
		
	}

}
