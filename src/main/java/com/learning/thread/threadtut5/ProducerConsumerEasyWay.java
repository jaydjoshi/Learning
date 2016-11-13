package com.learning.thread.threadtut5;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumerEasyWay {

	public static void main(String[] args) {
		System.out.println("Start");
		
		Helper helper = new Helper();
		BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(1);
		
		
		Thread producer = new Thread(new Producer(queue));
		producer.start();
		
		Thread consumer = new Thread(new Consumer(queue));
		consumer.start();
		
		System.out.println("End");
	}

}

class Helper{}

class Producer implements Runnable{
	private BlockingQueue<Integer> queue;
	private int[] arr = new int[20];
	
	public Producer(BlockingQueue helper) {
		this.queue=helper;
	}

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			try {
				queue.put(i);
				System.out.println("Value sent : "+i);
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
	
	public Consumer(BlockingQueue helper) {
		this.queue=helper;
	}

	@Override
	public void run() {
		while(true){
			try {
				int val = queue.take();
				System.out.println("Recieved value : "+val);
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
