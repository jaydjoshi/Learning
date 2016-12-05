package com.learning.thread.threadtut2;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ThreadTut2 {

	public static void main(String[] args) {
		Executor exec = Executors.newFixedThreadPool(2);
		exec.execute(new RunnableExample());
		exec.execute(new RunnableExample());
		exec.execute(new RunnableExample());
		exec.execute(new RunnableExample());
		
		
	}

}
