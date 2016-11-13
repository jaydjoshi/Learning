package com.learning.thread.threadtut6;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;

public class ProducerConsumerUsingSemaphore {

	public static void main(String[] args) {
		System.out.println("Start");
		
		BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(1);
		Semaphore producerSemaphore = new Semaphore(1);
		Semaphore consumerSemaphore = new Semaphore(0);
		
		Thread producer = new Thread(new Producer(producerSemaphore,consumerSemaphore,queue));
		producer.start();
		
		Thread consumer = new Thread(new Consumer(producerSemaphore,consumerSemaphore,queue));
		consumer.start();
		
		System.out.println("End");
	}

}


class Producer implements Runnable{
	private BlockingQueue<Integer> queue;
	private Semaphore producerSemaphore;
	private Semaphore consumerSemaphore;
	private int[] arr = new int[20];
	
	public Producer(Semaphore producerSemaphore,Semaphore consumerSemaphore,BlockingQueue<Integer> queue) {
		this.producerSemaphore=producerSemaphore;
		this.consumerSemaphore=consumerSemaphore;
		this.queue=queue;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				
				producerSemaphore.acquire();
				System.out.println("Value sent : "+i);
				queue.add(i);
				consumerSemaphore.release();
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
}

class Consumer implements Runnable{
	
	private BlockingQueue<Integer> queue;
	private Semaphore producerSemaphore;
	private Semaphore consumerSemaphore;
	
	public Consumer(Semaphore producerSemaphore,Semaphore consumerSemaphore,BlockingQueue<Integer> queue) {
		this.producerSemaphore=producerSemaphore;
		this.consumerSemaphore=consumerSemaphore;
		this.queue=queue;
	}

	@Override
	public void run() {
		while(true){
			try {
				consumerSemaphore.acquire();
				int val = queue.remove();
				producerSemaphore.release();
				System.out.println("Recieved value : "+val);
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
