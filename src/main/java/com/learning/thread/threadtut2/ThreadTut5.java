package com.learning.thread.threadtut2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class ThreadTut5 {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService exec = Executors.newCachedThreadPool();
		
		ArrayList<FutureTask<Integer>> futures = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		
		futures.add((FutureTask<Integer>) exec.submit(new CallableExample()));
		futures.add((FutureTask<Integer>) exec.submit(new CallableExample()));
		futures.add((FutureTask<Integer>) exec.submit(new CallableExample()));
		futures.add((FutureTask<Integer>) exec.submit(new CallableExample()));
		futures.add((FutureTask<Integer>) exec.submit(new CallableExample()));
		
		//future.get() awaits for the completion of the submit. Hence if called above it executes sequentially
		exec.shutdown();
		
		for (FutureTask<Integer> task : futures) {
			list.add((Integer) task.get());
		}
		list.forEach( (e) -> System.out.println(e));
	}

}

