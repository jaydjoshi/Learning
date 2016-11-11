package com.learning.thread.multithreading.executors;

public class ThreadPoolMain {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.out.println("Start");
		//ThreadPool threadPool = new ThreadPool(3);
		
		DuplicateThreadPool threadPool = new DuplicateThreadPool(2);
		threadPool.execute(new CommonTaskA(1));
		threadPool.execute(new CommonTaskA(2));
		threadPool.execute(new CommonTaskA(3));
		threadPool.execute(new CommonTaskA(4));
		
		threadPool.stop();
		//threadPool.stopNow();
		
		threadPool.execute(new CommonTaskA(5));
		
		System.out.println("End");
	}

}
