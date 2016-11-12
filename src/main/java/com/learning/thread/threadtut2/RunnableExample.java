package com.learning.thread.threadtut2;

public class RunnableExample implements Runnable {

	@Override
	public void run() {
		System.out.println("##############################");
		for (int i = 0; i < 10; i++) {
			System.out.println("Tick Tock: " + i);
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("***********************************");
	}
}
