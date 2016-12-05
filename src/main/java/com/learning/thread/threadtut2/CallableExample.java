package com.learning.thread.threadtut2;

import java.util.concurrent.Callable;

public class CallableExample implements Callable<Integer> {

	@Override
	public Integer call() throws Exception{
		int count ;
		for (int i = 0; i < 10; i++) {
			System.out.println("Tick Tock: " + i);
			try {
				/*if(i==3)
					count = i/0;*/
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		return (int) (Math.random()*10);
	}
}
