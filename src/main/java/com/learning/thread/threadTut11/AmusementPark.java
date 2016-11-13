package com.learning.thread.threadTut11;

import java.util.concurrent.CountDownLatch;

public class AmusementPark implements Runnable {
	private final int SIZE=3;
	CountDownLatch latch= new CountDownLatch(SIZE);

	@Override
	public void run() {
		try {
			latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Ride started with "+SIZE+" people.");
	}

}
