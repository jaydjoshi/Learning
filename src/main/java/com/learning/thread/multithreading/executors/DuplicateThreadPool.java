package com.learning.thread.multithreading.executors;

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionException;

public class DuplicateThreadPool {
	
	private BlockingQueue<Runnable> tasks = null;
	
	private int modSize = 0;
	private Worker worker = null;
	private Thread thread = null;
	private volatile boolean isStopped = false;
	
	public DuplicateThreadPool(int size) {
		this.modSize=size;
		
		tasks = new ArrayBlockingQueue<>(modSize);
		for(int i = 0 ; i< size ; i++){
			worker = new Worker();
			thread = new Thread(worker,String.valueOf(i));
			thread.start();
		}
	}
	
	private class Worker implements Runnable{
		@Override
		public void run() {
			while(!isStopped){
				try {
					tasks.take().run();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	public void execute(Runnable runnable){
		
		if(isStopped){
			throw new RejectedExecutionException();
		}
		try {
			tasks.put(runnable);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void stop() {
		while(true && !isStopped){
			if(tasks.isEmpty()){
				isStopped= true;
				break;
			}
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	public void stopNow() {
		while(true && !isStopped){
			isStopped= true;
			break;
		}
		
	}

}
