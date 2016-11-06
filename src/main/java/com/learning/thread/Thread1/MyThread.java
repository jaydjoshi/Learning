package com.learning.thread.Thread1;

public class MyThread extends Thread {
	
	@Override
	public void run() {
		System.out.println("Thread started running from MyThread class.....");
		
		try {
			Thread.sleep(1000);
			doDBProcessing();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Thread ended from MyThread class.....");
	}
	
	private void doDBProcessing() throws InterruptedException {
		// TODO Auto-generated method stub
		Thread.sleep(5000);
		
	}

}
