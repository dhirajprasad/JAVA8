package com.dp.thread;

public class SynchroniseEx {

	public static void main(String[] args) {

		Shared s = new Shared();
		Thread t0 = new Thread(new Worker(s),"t0");
		Thread t1 = new Thread(new Worker(s),"t1");
		t0.start();
		t1.start();
	}

}
class Worker implements Runnable{

	Shared shared;
	Worker(Shared shared){
		this.shared = shared;
	}
	@Override
	public void run() {
		shared.sharedMethod();
	}
	
}
class Shared{
	 public Shared() {
	}
	 synchronized void  sharedMethod(){
		System.out.println(Thread.currentThread().getName() + " A");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread()+"B");
	}
}