package com.dp.thread;

public class ProdConsProblem {

	public static void main(String[] args) {
		ResourceFactory resource = new ResourceFactory();
		Thread tp = new Thread(new Producer(resource));
		Thread tc = new Thread(new Consumer(resource));
		tc.start();
		tp.start();

	}

}
class Consumer implements Runnable{

	ResourceFactory resource;
	public Consumer() {
	}
	
	public Consumer(ResourceFactory resource) {
		this.resource = resource;
	}
	@Override
	public void run() {
		System.out.println("consumer is running ");
		String item =resource.consume();
		System.out.println("consumed "+item);
	}
	
}
class Producer implements Runnable{

	ResourceFactory resource;
	public Producer() {
	}
	
	public Producer(ResourceFactory resource) {
		this.resource = resource;
	}

	@Override
	public void run() {
		System.out.println("producer is running ");
		for (int i = 1; i < 3; i++) {
			resource.produce(""+i);
			System.out.println("produced :" + i);
			
		}
		
	
		
	}
	
}
class ResourceFactory{
	String item;
	boolean isAvailable = false;
	public ResourceFactory() {
	}
	
	synchronized String consume(){
		while(isAvailable==false){
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		isAvailable=false;
		notifyAll();
		return item;
	}
	synchronized void produce(String item){
		while(isAvailable == true){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.item=item;
		isAvailable=true;
		notifyAll();
		
	}
	
}