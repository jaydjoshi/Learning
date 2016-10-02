package com.learning.thread;

public class MyRunnableThread implements Runnable{

	@Override
	public void run() {
		System.out.println("Thread from MyRunnableThread class started running.....");
		try {
			Thread.sleep(1000);
			doDBProcessing();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Thread from MyRunnableThread class ends.....");
	}

	private void doDBProcessing() throws InterruptedException {
		// TODO Auto-generated method stub
		Thread.sleep(5000);
		
	}
	
}


