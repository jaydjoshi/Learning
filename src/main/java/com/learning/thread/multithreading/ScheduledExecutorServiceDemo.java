package com.learning.thread.multithreading;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServiceDemo {

	public static void main(String[] args) {
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);
		
		for (int i = 0; i < 5; i++) {
			executor.submit(new ProcessorSc(i));
		}
		
		executor.shutdown();
		
		System.out.println("All task submitted.");
		try {
			executor.awaitTermination(2, TimeUnit.HOURS);
		} catch (InterruptedException e) {
		}
		
		System.out.println("All task completed. :)");
	}
}


class ProcessorSc implements Runnable{
	
	private int id;
	
	public ProcessorSc(int id) {
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