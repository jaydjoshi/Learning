package com.learning.thread.multithreading;

import java.util.Random;

public class ProducerConsumer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Main method start");
		Message m = new Message();
		(new Thread(new Producer(m))).start();
		(new Thread(new Consumer(m))).start();
		System.out.println("Main method end");
	}

}

class Message{
	private String message;
	private boolean empty= true;
	
	public synchronized void send(String message){
		System.out.println("Message '"+ message+ "' has entered send function!");
		while(!empty){
			try {
				wait();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		empty=false;
		this.message=message;
		notifyAll();
		System.out.println("Message '"+ message+ "' sent!");
	}
	
	public synchronized String receive(){
		System.out.println("Message receive function()!");
		while(empty){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		empty=true;
		notifyAll();
		System.out.println("Message '"+ message+ "' received!");
		return message;
	}
}

class Producer implements Runnable{
	private Message message;
	
	public Producer(Message message) {
		// TODO Auto-generated constructor stub
		this.message= message;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		String[] str = {"This is ","an important ","encryped message received ","from Platovi database"};
		Random random = new Random();
		for (String string : str) {
			try {
				message.send(string);
				Thread.sleep(random.nextInt(1000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		message.send("Done");
	}
	
}

class Consumer implements Runnable{
	private Message message;
	
	public Consumer(Message message) {
		// TODO Auto-generated constructor stub
		this.message= message;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			Random random = new Random();
			//String msg = message.receive();
			
			/*for (String msg = message.receive();
		             ! msg.equals("Done");
					msg = message.receive()) {
				System.out.format("MESSAGE RECEIVED: %s%n", msg);
			}*/
			do{
				System.out.println(message.receive());
			}while(!message.receive().equals("Done"));
			
			Thread.sleep(random.nextInt(1000));
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
