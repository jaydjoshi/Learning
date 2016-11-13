package com.learning.thread.threadTut11;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarierDemo {

	public static void main(String[] args) {
		
		CyclicBarrier barrier = new CyclicBarrier(4, () -> {
			System.out.println("Lets play everyone reached");
		});
		
		Friend park = new Friend(barrier);
		
		System.out.println("Amusment park started");
		
		Thread t1 = new Thread(park,"Person1");
		Thread t2 = new Thread(park,"Person2");
		Thread t3 = new Thread(park,"Person3");
		Thread t4 = new Thread(park,"Person4");
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
	}

}
