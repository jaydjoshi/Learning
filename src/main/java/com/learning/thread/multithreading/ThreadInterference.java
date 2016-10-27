package com.learning.thread.multithreading;

public class ThreadInterference {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Thread t1 = new Thread(new Counter(), "Counter1");
		t1.start();
		Thread t2 = new Thread(new Counter(), "Counter2");
		t2.start();
		
	}

}

class Counter implements Runnable{
    private int c = 0;

    public void increment() {
        c++;
    }

    public void decrement() {
        c--;
    }

    public int value() {
        return c;
    }

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 5; i++) {
			try {
				Thread.sleep(1000);
				increment();
				Thread.sleep(1500);
				decrement();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println(value());
			
		}
		
	}

}
