package com.learning.thread.multithreading.executors;

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ThreadPool {

	private BlockingQueue<Runnable> tasks = null;
	private ArrayList<Worker> workers = null;
	Worker oneWorker = new Worker();
	private int size;
	private int maxSize;
	private int modCount=0;
	
	public ThreadPool(int n) {
		size=n;
		maxSize=n;
		workers = new ArrayList<>(size);
		tasks =  new ArrayBlockingQueue<>(size);
		Thread thread = null;
		for (int i = 0 ; i< size; i++) {
			oneWorker = new Worker();
			thread = new Thread(oneWorker);
			thread.start();
		}
		
	}
	
	private class Worker implements Runnable{

		@Override
		public void run() {
			while(true){
				try {
					tasks.take().run();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	public void execute(Runnable runnable) throws InterruptedException{
		try {
			tasks.put(runnable);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
