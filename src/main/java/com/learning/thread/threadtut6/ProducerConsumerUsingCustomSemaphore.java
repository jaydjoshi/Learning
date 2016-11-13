package com.learning.thread.threadtut6;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumerUsingCustomSemaphore {

	public static void main(String[] args) {
		System.out.println("Start");
		
		BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(1);
		SemaphoreCustom producerSemaphore = new SemaphoreCustom(1);
		SemaphoreCustom consumerSemaphore = new SemaphoreCustom(0);
		
		Thread producer = new Thread(new Producer1(producerSemaphore,consumerSemaphore,queue));
		producer.start();
		
		Thread consumer = new Thread(new Consumer1(producerSemaphore,consumerSemaphore,queue));
		consumer.start();
		
		System.out.println("End");
	}

}


class Producer1 implements Runnable{
	private BlockingQueue<Integer> queue;
	private SemaphoreCustom producerSemaphore;
	private SemaphoreCustom consumerSemaphore;
	private int[] arr = new int[20];
	
	public Producer1(SemaphoreCustom producerSemaphore,SemaphoreCustom consumerSemaphore,BlockingQueue<Integer> queue) {
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

class Consumer1 implements Runnable{
	
	private BlockingQueue<Integer> queue;
	private SemaphoreCustom producerSemaphore;
	private SemaphoreCustom consumerSemaphore;
	
	public Consumer1(SemaphoreCustom producerSemaphore,SemaphoreCustom consumerSemaphore,BlockingQueue<Integer> queue) {
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
