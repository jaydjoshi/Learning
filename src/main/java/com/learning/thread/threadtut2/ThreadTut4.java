package com.learning.thread.threadtut2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class ThreadTut4 {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService exec = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors()+1);
		System.out.println("Start");
		ArrayList<FutureTask<Integer>> futures = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		try{
		Future future = (FutureTask<Integer>) exec.submit(new CallableExample());
		boolean flag = future.cancel(false);
		
		System.out.println(flag);
		
		/*futures.add((FutureTask<Integer>) exec.submit(new CallableExample()));
		futures.add((FutureTask<Integer>) exec.submit(new CallableExample()));
		futures.add((FutureTask<Integer>) exec.submit(new CallableExample()));
		futures.add((FutureTask<Integer>) exec.submit(new CallableExample()));*/
		}
		catch(Exception e){
			System.out.println("exception catched");
		}
		
			System.out.println("End");	
		//future.get() awaits for the completion of the submit. Hence if called above it executes sequentially
		exec.shutdown();
		/*
		for (FutureTask<Integer> task : futures) {
			task.cancel(true);
			list.add((Integer) task.get());
		}
		
		
		list.forEach( (e) -> System.out.println(e));*/
	}

}

