package com.dp.thread;

public class JoinExample {

	public static void main(String[] args) {

		Thread t1 = new Thread(()->{
			try {
				Thread.sleep(1000);
				for(int i=0;i<10;i++){
					
					System.out.println(i);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread());
		},"T1");
		
		Thread t2 = new Thread(()->{
			System.out.println(Thread.currentThread());
		},"T2");
		
		t1.start();
		try {
			t1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t2.start();
	}

}
