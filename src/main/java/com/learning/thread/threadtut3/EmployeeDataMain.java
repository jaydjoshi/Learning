package com.learning.thread.threadtut3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class EmployeeDataMain {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		List<Integer> ids = new ArrayList<>();
		List<ArrayList<Integer>> lists = new ArrayList<>();
		ArrayList<Integer> array = new ArrayList<>();
		ArrayList<FutureTask> futures = new ArrayList<>();
		for (int i = 0; i < 1000; i++) {
			ids.add(i);
		}
		int count = 0;
		for (int i = 0; i <= 100 && count < ids.size(); i++) {
			//array = new int[100];
			array.add(ids.get(count++));
			if(i==100){
				i=0;
				lists.add(array);
				array = new ArrayList<>();
			}
		}
		lists.add(array);
		
		System.out.println("Start");
		
		ExecutorService exec = Executors.newFixedThreadPool(4);
		int count1=0;
		
		for (List list : lists) {
			if(list!=null){
				futures.add((FutureTask) exec.submit(new WorkerList(list, "Thread"+ ++count1)));
			}
		}
		
		exec.shutdown();
		
		exec.awaitTermination(2, TimeUnit.MINUTES);
		int result = 0;
		for (FutureTask futureTask : futures) {
			System.out.println("Retruned value : "+futureTask.get());
			result = result + (Integer)futureTask.get(); 
		}
		
		System.out.println("Number of retrived employees :"+result);
		
	}

}
