package com.learning.thread.threadtut7;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerUsingCondition {

	public static void main(String[] args) {
		System.out.println("Start");
		
		BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(1);
		Lock lock = new ReentrantLock();
		Condition producerCondition = lock.newCondition();
		Condition consumerCondition = lock.newCondition();
		
		
		Thread producer = new Thread(new Producer(lock,producerCondition,consumerCondition,queue));
		producer.start();
		
		Thread consumer = new Thread(new Consumer(lock,producerCondition,consumerCondition,queue));
		consumer.start();
		
		System.out.println("End");
	}

}


class Producer implements Runnable{
	private BlockingQueue<Integer> queue;
	Lock lock;
	Condition producerCondition ;
	Condition consumerCondition ;
	
	
	public Producer(Lock lock,Condition producerCondition ,Condition consumerCondition,BlockingQueue<Integer> queue) {
		this.lock=lock;
		this.consumerCondition=consumerCondition;
		this.producerCondition=producerCondition;
		this.queue=queue;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				lock.lock();
				if(queue.size()==1){
					producerCondition.await();
				}
				
				System.out.println("Value sent : "+i);
				queue.add(i);
				consumerCondition.signal();
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally{
				lock.unlock();
			}
			
		}
	}
	
}

class Consumer implements Runnable{
	
	private BlockingQueue<Integer> queue;
	Lock lock;
	Condition producerCondition ;
	Condition consumerCondition ;
	
	
	public Consumer(Lock lock,Condition producerCondition ,Condition consumerCondition,BlockingQueue<Integer> queue) {
		this.lock=lock;
		this.consumerCondition=consumerCondition;
		this.producerCondition=producerCondition;
		this.queue=queue;
	}

	@Override
	public void run() {
		while(true){
			try {
				lock.lock();
				if(queue.size()==0){
					consumerCondition.await();
				}
				
				int val = queue.remove();
				producerCondition.signal();
				System.out.println("Recieved value : "+val);
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally{
				lock.unlock();
			}
		}
	}
	
}
