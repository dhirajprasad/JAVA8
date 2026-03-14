package com.dp.datastructure;

public class MyQ {

	public static void main(String[] args) {
		MyQueue q = new MyQueue(2);
		q.enq(2);
		q.enq(3);
		q.enq(3);q.deq();q.enq(3);
		
		System.out.println(q.deq());
		System.out.println(q.deq());
		
		q.enq(13);
		//System.out.println(q.deq());
		System.out.println(q.deq());
	}

}
class MyQueue{
	int[] arr;int front=-1,rear =-1;
	int capacity;
	public MyQueue(int size) {
		super();
		this.arr = new int[size];
		capacity=size;
	}
	void enq(int x){
		if(rear == capacity-1){
			System.out.println("overflow");
			//rear=-1;
		}else if(front == -1&& rear == -1){
			front =rear = 0;
			arr[rear]=x;
		}else{
			arr[++rear]=x;
		}
	}
	int deq(){
		int x = 0;
		if(front == -1&& rear == -1){
			System.out.println("nothing to delete");
		}else if(front == rear ) {
			x=arr[front];
			front = rear = -1;
			
		}else{
			return arr[front++];
		}
		return x;
	}
	
	
	
}