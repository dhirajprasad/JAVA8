package com.dp.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ExecutorFramework {

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		
		ExecutorService ex = Executors.newFixedThreadPool(2);
		Future<String> worker1 =  ex.submit(()->{
			System.out.println("worker1"+Thread.currentThread().getName());
			
			Thread.currentThread().sleep(6000);
			return "finished-worker1";
		});
		Future<String> worker2 =  ex.submit(()->{
			System.out.println("worker2"+Thread.currentThread().getName());
			Thread.currentThread().sleep(6000);
			return "finished-worker2";
		});
		System.out.println("=====");
		try {
			String oo = null;
			try {
				oo = worker2.get(10, TimeUnit.SECONDS);
			} catch (TimeoutException e) {
				e.printStackTrace();
			}
			System.out.println(oo);
			String o= worker1.get();
			
			System.out.println(o);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

}


	
}