package com.learning.thread.threadtut1;

public class ThreadTut1 {

	public static void main(String[] args) {
		RunnableExample runnable = new RunnableExample();
		Thread thread1 = new Thread(runnable);
		thread1.start();
		
		Thread thread2= new ThreadExample();
		thread2.start();
				
	}

}

class RunnableExample implements Runnable{

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("Tick Tock: "+i);
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}

class ThreadExample extends Thread{
	
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("Tick Tock: "+i);
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
