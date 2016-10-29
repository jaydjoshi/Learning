package com.learning.thread.multithreading;

public class SimpleThread{

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.out.println("Main method");
		//Execution with thread
		ThreadExample t1 = new ThreadExample("Thread1");
		t1.start();
		//t1.join();
		ThreadExample t2 = new ThreadExample("Thread2");
		t2.start();
		//t2.join(); //pauses current thread until t2 is terminated
		
		//Execution with runnable interface
		ThreadExampleRunnable runnable = new ThreadExampleRunnable();
		Thread runnableThread = new Thread(runnable,"runnableThread");
		runnableThread.start();
		//runnableThread.join();
		
		ThreadExample t3 = new ThreadExample("Thread3");
		t3.start();
		
		System.out.println("Done execution");
	}

}

class ThreadExample extends Thread{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		Object mutex = new Object();
		System.out.println("Thread from Thread class: "+ Thread.currentThread().getName());
		for (int i = 0; i < 10; i++) {
			try {
				synchronized (mutex) {
					sleep(1000);
					System.out.println("Thread class after sleep "+i);
				}
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public ThreadExample() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	public ThreadExample(String name) {
		// TODO Auto-generated constructor stub
		super(name);
	}

}

class ThreadExampleRunnable implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Thread from Thread class which implements runnable interface: "+Thread.currentThread().getName());

		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(1000);
				System.out.println("Runnable interface after sleep "+i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
