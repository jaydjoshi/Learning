package com.learning.thread.threadtut4;

import java.util.Random;

public class ProducerConsumerHardWay {

	public static void main(String[] args) {
		System.out.println("Start");
		
		Helper helper = new Helper();
		
		Thread producer = new Thread(new Producer(helper));
		producer.start();
		
		Thread producer1 = new Thread(new Producer(helper));
		producer1.start();
		
		Thread consumer = new Thread(new Consumer(helper));
		consumer.start();
		
		Thread consumer1 = new Thread(new Consumer(helper));
		consumer1.start();
		
		System.out.println("End");
	}

}

class Helper{
	int value;
	boolean isEmpty = true;
	
	public synchronized void send(int i){
		System.out.println("######## Value : "+i+" sent started ########");
		while(!isEmpty){
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		isEmpty= false;
		this.value=i;
		notifyAll();
		System.out.println("######## Value : "+i+" sent ended ########");
	}
	
	public synchronized int recieve(){
		System.out.println("******** Value :  recived started ********");
		while(isEmpty){
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		isEmpty=true;
		notifyAll();
		System.out.println("******** Value : "+value+" recived ********");
		return value;
		
	}
	
	
	
}

class Producer implements Runnable{
	private Helper helper;
	private int[] arr = new int[20];
	
	public Producer(Helper helper) {
		this.helper=helper;
	}

	@Override
	public void run() {
		for (int i = 0; i < arr.length; i++) {
			
			helper.send(i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		helper.send(-1);
	}
	
}

class Consumer implements Runnable{
	
	private Helper helper;
	
	public Consumer(Helper helper) {
		this.helper=helper;
	}

	@Override
	public void run() {
		
		try {
			Random random = new Random();
			
			do{
				System.out.println(helper.recieve());
			}while(helper.recieve()!=-1);
			
			Thread.sleep(random.nextInt(400));
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	
		
	}
	
}
