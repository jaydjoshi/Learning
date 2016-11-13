package com.learning.thread.threadtut3;

import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;

public class WorkerList implements Callable<Integer> {
	
	List<Integer> list;
	String name;
	Random random = new Random();
			
			
	
	public WorkerList(List list,String name) {
		this.list=list;
		this.name=name;
	}
	
	@Override
	public Integer call() throws Exception {
		System.out.println("************Start thread************ "+name);
		System.out.println("List size: "+list.size());
		int returnVal = doDbProcessing(list);
		return returnVal;
	}

	private int doDbProcessing(List<Integer> list2) throws InterruptedException {
		
		Thread.sleep(5000);
		return (int) (Math.random()*100);
	}

}
