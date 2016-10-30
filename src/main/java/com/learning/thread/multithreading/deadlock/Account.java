package com.learning.thread.multithreading.deadlock;

public class Account {
	
	private int balance=10000;
	
	public int getBalance(){
		return balance;
	}
	
	public void withdraw(int amount){
		balance -= amount;
	}
	
	public void debit(int amount){
		balance += amount;
	}
	
	public static void transfer(int amount, Account acc1 , Account acc2){
		acc1.withdraw(amount);
		acc2.debit(amount);
	}

}
