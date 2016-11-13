package com.learning.thread.threadtut9;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadlockDemo {

	public static void main(String[] args) {
		
		Runner run = new Runner();
		
		Thread t1 = new Thread(() -> {
			try {
				run.methodOne();
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		
		Thread t2 = new Thread(() -> {
			try {
				run.methodTwo();
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		run.display();

	}

}

class Runner {
	
	Random random = new Random();
	private Account one = new Account();
	private Account two = new Account();
	Lock lock1 = new ReentrantLock();
	Lock lock2 = new ReentrantLock();
	
	void acquireLock(Lock lock1 , Lock lock2) throws InterruptedException{
		
		while(true){
			Boolean isLockOneLocked = false; 
			Boolean isLockTwoLocked = false;
			
			try {
				isLockOneLocked = lock1.tryLock();
				isLockTwoLocked = lock2.tryLock();
			} catch (Exception e) {
				e.printStackTrace();
			}
			finally{
				if(isLockOneLocked && isLockTwoLocked){
					return;
				}
				if(isLockOneLocked){
					lock1.unlock();
				}
				if(isLockTwoLocked){
					lock2.unlock();
				}
			}
			Thread.sleep(1);
		}
		
	}
	
	
	void methodOne() throws InterruptedException{
		
		for (int i = 0; i < 10000; i++) {
			
			acquireLock(lock1, lock2);
			try{
				Account.transfer(random.nextInt(100), one, two);
			}
			finally{
				lock2.unlock();
				lock1.unlock();
			}
			
		}
		
	} 
	
	void methodTwo() throws InterruptedException{
		
		for (int i = 0; i < 10000; i++) {
			
			acquireLock(lock2, lock1);
			try{
				Account.transfer(random.nextInt(100), two, one);				
			}
			finally{				
				lock1.unlock();
				lock2.unlock();
			}
		}
	}
	
	void display(){
		System.out.println("Account one balance: "+one.getBalance());
		System.out.println("Account two balance: "+two.getBalance());
		System.out.println("Total: "+(one.getBalance()+two.getBalance()));
	}
	
}


