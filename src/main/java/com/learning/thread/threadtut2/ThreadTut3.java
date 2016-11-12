package com.learning.thread.threadtut2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadTut3 {

	public static void main(String[] args) {
		ExecutorService exec = Executors.newFixedThreadPool(2);
		exec.submit(new RunnableExample());
		exec.submit(new RunnableExample());
		exec.submit(new RunnableExample());
		exec.submit(new RunnableExample());
		
		exec.shutdown();
	}

}

