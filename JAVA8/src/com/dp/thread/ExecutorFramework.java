package com.dp.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorFramework {

	public static void main(String[] args) {

		Thread WorkerA = new Thread(new Task());
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		@SuppressWarnings("rawtypes")
		Future f = executorService.submit(WorkerA);
		System.out.println("submitted the task");
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
		int i = 0;//Integer.MIN_VALUE/6000;
		while (i<9){
			i++;
			System.out.println(i);
		}
		System.out.println(Thread.currentThread());
	}
	
}