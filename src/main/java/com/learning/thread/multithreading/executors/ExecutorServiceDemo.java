package com.learning.thread.multithreading.executors;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceDemo {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService executor = Executors.newFixedThreadPool(2);
		java.util.concurrent.Future<Integer> f = null;
		for (int i = 0; i < 5; i++) {
			//executor.submit(new Processor(i));
			  f = (java.util.concurrent.Future) executor.submit(new ProcessCall(i));
		}
		
		executor.shutdown();
		
		System.out.println(f.get());
		
		System.out.println("All task submitted.");
		try {
			executor.awaitTermination(2, TimeUnit.HOURS);
		} catch (InterruptedException e) {
		}
		
		System.out.println("All task completed. :)");
	}
}


class Processor implements Runnable{
	
	private int id;
	
	public Processor(int id) {
		this.id=id;
	}

	@Override
	public void run(){
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

class ProcessCall implements Callable<Integer> {

	private int id;

	public ProcessCall(int id) {
		this.id=id;
	}

	@Override
	public Integer call() throws Exception {
		// TODO Auto-generated method stub

		// process
		System.out.println("Start : " + id);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("End : " + id);

		return id;
	}

}