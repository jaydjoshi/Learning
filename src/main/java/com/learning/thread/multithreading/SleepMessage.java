package com.learning.thread.multithreading;

public class SleepMessage {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		String[] messages = {"This is", " an important message", " received from"," platovi database"};
		int count=0;
		for (String string : messages) {
			count++;
			if(count==1){
				Thread.interrupted();
			}
			Thread.sleep(2000);
			System.out.print(string);
		}

	}

}
