package com.learning.thread.multithreading.executors;

public class CommonTaskA implements Runnable {
	
	private int i;
	
	public CommonTaskA(int i) {
		this.i=i;
	}

	@Override
	public void run() {
		System.out.println("############# Task "+i+" started ###########" );
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep((long)(Math.random()*1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Tick tock : "+i);
		}
		System.out.println("************ Task "+i+" ended ************" );
	}

}
