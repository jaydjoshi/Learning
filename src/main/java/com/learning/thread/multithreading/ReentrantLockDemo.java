package com.learning.thread.multithreading;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {
	
	public static void main(String[] args) {
		
		Counterr c =new Counterr();
		Thread t1 = new Thread(c, "Counter1");
		Thread t2 = new Thread(c, "Counter2");
		System.out.println("Before value is : "+c.value());
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("After value is : "+c.value());
	}

}


class Counterr implements Runnable{
    private int c = 0;
    private Lock lock = new ReentrantLock();
    private Condition con = lock.newCondition();
    private Semaphore sem = new Semaphore(10);
    
    public void increment() {
    	c++;
    }

    public int value() {
        return c;
    }

	@Override
	public void run() {
		for (int i = 0; i < 10000; i++) {
			lock.lock();
			try{
				increment();
			}
			finally{
				lock.unlock();
			}
		}
		
	}

}