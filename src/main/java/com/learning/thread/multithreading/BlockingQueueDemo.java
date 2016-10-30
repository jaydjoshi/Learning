package com.learning.thread.multithreading;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueDemo {

	public static void main(String[] args) {
		BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(10);
		Thread t1 = new Thread(new ProducerBlock(blockingQueue));
		Thread t2 = new Thread(new ConsumerBlock(blockingQueue));
		Thread t3 = new Thread(new ConsumerBlock(blockingQueue));
		
		t1.start();
		t2.start();
		t3.start();
		
		try {
			t1.join();
			t2.join();
			t3.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

class ProducerBlock implements Runnable {
	
	BlockingQueue<Integer> queue;
	
	public ProducerBlock(BlockingQueue<Integer> queue) {
		this.queue=queue;
	}
	
	public void run() {
		Random random = new Random();
		while(true){
			try {
				int num = random.nextInt(100);
				queue.put(num);
				System.out.println("Number: "+num+" inserted");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}

class ConsumerBlock implements Runnable {
	
	BlockingQueue<Integer> queue;
	
	public ConsumerBlock(BlockingQueue<Integer> queue) {
		this.queue=queue;
	}
	
	public void run() {
		while(true){
			try {
				Thread.sleep(10);
				int num = queue.take();
				System.out.println("Number: "+num+" taken");
				System.out.println("Size: "+queue.size());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}