package com.dp.thread;

import java.util.concurrent.Callable;

public class ThreadState {

	public static void main(String[] args) {
		System.out.println(Thread.currentThread());
		System.out.println(Thread.activeCount());
		Thread t = new Thread(new Mythread(),"Mythread");
		Thread t1 = new Thread(new Mythread(),"Mythread");
		t.start();Callable c;
		t1.start();
		System.out.println("after starting Mythread:"+Thread.activeCount());
		
		
	}

}
class Mythread implements Runnable{

	@Override
	public void run() {
		System.out.println(Thread.currentThread());
		System.out.println("inside Mythread"+Thread.activeCount());
		 new Thread(()->{
				System.out.println(">>><<<<"+Thread.currentThread());
			},"XXX").start();
	}
	
}