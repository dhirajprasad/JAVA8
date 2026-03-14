package com.dp.datastructure;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class TreeDemo {

	public static void main(String[] args) {

		System.out.println(" sdfa hello java ");
		Map<Integer, String> empMap = new HashMap<>();
		empMap.put(1001, "ajay");
		empMap.put(1002, "John");
		empMap.put(1003, "dhiraj");
		empMap.put(1003, "dhiraj");
		empMap.put(1003, "don");
		System.out.println("empmap"+empMap);
		Set<Integer> intset = new HashSet<>();
		intset.add(1);
		intset.add(11);
		intset.add(1);intset.add(101);
		System.out.println(intset);
		Iterator<Integer> iter = empMap.keySet().iterator();
		while(iter.hasNext()){

			int key = iter.next();
			if(empMap.get(key).equals("don")){
				//empMap.remove(key);
				//iter.remove();
				String old =empMap.replace(key, "prime");
				System.out.println(old);
			}

		}
		System.out.println(empMap);
		
	}

}
class MyTree{
	Node root;
	class Node{
		int data;
		Node left,right;
		public Node(int data) {
			super();
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}
	
	
}