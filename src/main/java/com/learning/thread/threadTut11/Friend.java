package com.learning.thread.threadTut11;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Friend implements Runnable {
	
	CyclicBarrier barrier;

	public Friend(CyclicBarrier barrier) {
		this.barrier=barrier;
	}

	@Override
	public void run() {
		
		try {
			Thread.sleep((long) (Math.random()*4000));
			System.out.println(Thread.currentThread().getName()+ " has reached ");
			barrier.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}
		
		System.out.println(Thread.currentThread().getName()+ " has started playing  ");
	}

}
