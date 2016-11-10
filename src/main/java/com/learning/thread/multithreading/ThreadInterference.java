package com.learning.thread.multithreading;

public class ThreadInterference {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Counter c =new Counter();
		Thread t1 = new Thread(c, "Counter1");
		Thread t2 = new Thread(c, "Counter2");
		System.out.println("Before value is : "+c.value());
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("After value is : "+c.value());
	}

}

class Counter implements Runnable{
    private volatile int c = 0;

    public void increment() {
    	
    	synchronized(this){
    		c++;
    	}
    }

    public int value() {
        return c;
    }

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 10000; i++) {
			increment();
		}
		
	}

}
