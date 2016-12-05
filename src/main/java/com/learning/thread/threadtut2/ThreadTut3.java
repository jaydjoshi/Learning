package com.learning.thread.threadtut2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadTut3 {

	public static void main(String[] args) {
		ExecutorService exec = Executors.newFixedThreadPool(2);
		exec.submit(new RunnableExample());
		exec.submit(new RunnableExample());
		exec.submit(new RunnableExample());
		exec.submit(new RunnableExample());
		
		exec.shutdown();
		
		try {
			
			System.out.println("Waiting");
			Thread.sleep(100);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			System.out.println("being terminated");
			exec.awaitTermination(5,TimeUnit.SECONDS);
			System.out.println("being terminated final");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

