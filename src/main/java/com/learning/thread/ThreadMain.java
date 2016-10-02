package com.learning.thread;

public class ThreadMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Starting Runnable methods");
		
		MyRunnableThread r1 = new MyRunnableThread();
		Thread t1 = new Thread(r1);
		t1.start();
		
		System.out.println("Runnable methods ends");
		
		System.out.println("Starting Thread methods");
		MyThread mt = new MyThread();
		mt.start();
		
		System.out.println("Thread methods ends");

	}

}
