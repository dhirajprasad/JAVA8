package com.dp.datastructure;

public class MyList {

	public static void main(String[] args) {
		CustomList list = new CustomList();
		list.add(3);
		list.add(5);
		list.add(25);
		list.add(15);
		list.show();
		list.rev();
	}

}
class CustomList{
	Node head;
	class Node{
		int data;
		Node next;
		public Node(int data) {
			super();
			this.data = data;
			this.next = null;
		}
	}
	public void add(int x){
		Node temp = new Node(x);
		if(head == null){
			head =temp;
		}else{
			Node ptr =head;
			while(ptr.next!=null){
				ptr=ptr.next;
			}
			ptr.next= temp;
		}
		
	}
	void show(){
		Node temp=head;
		while(temp!=null){
			System.out.print(temp.data +" ");
			temp = temp.next;
		}
	}
	void rev(){
		reverse(this.head);
	}
	private void reverse(Node temp ){
		if(temp == null){
			return;
		}
		reverse(temp.next);
		System.out.print(" "+temp.data);
		
	}
	
}