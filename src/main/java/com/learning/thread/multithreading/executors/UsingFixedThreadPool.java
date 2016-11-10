package com.learning.thread.multithreading.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UsingFixedThreadPool {

	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		
		exec.submit(new CommonTaskA(1));
		exec.submit(new CommonTaskA(2));
		exec.submit(new CommonTaskA(3));
		exec.submit(new CommonTaskA(4));
		exec.submit(new CommonTaskA(5));
		
		exec.shutdown();
		
	}

}
