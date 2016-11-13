package com.learning.thread.threadTut11;

import java.util.concurrent.CountDownLatch;

public class AmusementPark implements Runnable {
	
	CountDownLatch latch;

	public AmusementPark(CountDownLatch latch) {
		this.latch=latch;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+ " is on his way ");
		try {
			Thread.sleep((long) (Math.random()*4000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		latch.countDown();
		System.out.println(Thread.currentThread().getName()+ " has reached ");
	}

}
