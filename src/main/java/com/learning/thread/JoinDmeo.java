package com.learning.thread;

public class JoinDmeo {

	public static void main(String[] args) {
		Thread t1 = new Thread(new ThreadDemo("1"),"1");
		Thread t2 = new Thread(new ThreadDemo("2"),"2");
		Thread t3 = new Thread(new ThreadDemo("3"),"3");
		
		t1.start();
		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		t2.start();
		try {
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		t3.start();
		try {
			t3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Start");
		
		new ThreadDemo("1").run();
		new ThreadDemo("2").run();
		new ThreadDemo("3").run();
		
		System.out.println("Everything fininshed");
		
	}

}

class ThreadDemo implements Runnable {
	
	private String name;
	
	public ThreadDemo(String string) {
		// TODO Auto-generated constructor stub
		name=string;
	}

	@Override
	public void run() {
		try {
			synchronized (this) {
				System.out.println("Inside run method "+Thread.currentThread().getName());
				System.out.println("Inside run method "+name);
				Thread.sleep(4000);
			}
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}