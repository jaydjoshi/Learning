package com.learning.thread.multithreading;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ExecutorDemo {

	public static void main(String[] args) {
		/*Executor executor = Executors.newFixedThreadPool(2);*/
		/*Executor executor = Executors.newCachedThreadPool();*/
		/*Executor executor = Executors.newSingleThreadExecutor();*/
		
		Executor executor = Executors.newWorkStealingPool(2);
		
		for (int i = 0; i < 5; i++) {
			executor.execute(new ProcessorEx(i));
		}
		System.out.println("All task submitted.");
		
		System.out.println("All task completed. :)");
	}
}

class ProcessorEx implements Runnable{
	
	private int id;
	
	public ProcessorEx(int id) {
		this.id=id;
	}

	@Override
	public void run() {
		//process
		System.out.println("Start : "+id);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("End : "+id);
	}
	
}