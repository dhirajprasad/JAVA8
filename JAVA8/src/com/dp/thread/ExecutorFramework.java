package com.dp.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorFramework {

	public static void main(String[] args) {

		Thread WorkerA = new Thread(new Task());
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		Future f = executorService.submit(WorkerA);
		try {
			Object o= f.get();
			System.out.println(o);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}

}

class Task implements Runnable{

	@Override
	public void run() {
		int i = Integer.MIN_VALUE;
		while (i<Integer.MAX_VALUE){
			i++;
			System.out.println(i);
		}
		System.out.println(Thread.currentThread());
	}
	
}