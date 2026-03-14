package com.dp.main;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@FunctionalInterface
interface Fun{
	void fun();
	default void m(){
		System.out.println("default >>> m");
	}
}
class Mycomparator implements Comparator<String>{

	@Override
	public int compare(String o1, String o2) {
		return o1.compareTo(o2);
	}
	
}
class Student {
	private int roll;

	public int getRoll() {
		return roll;
	}

	public void setRoll(int roll) {
		this.roll = roll;
	}
	
}
public class streamEx {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Runnable work = ()->{
			System.out.println("run method inside runnable ");
		};
		
		Thread t = new Thread() {
			public void run() {
				System.out.println("thread");
			}
		};
		t.start();
		Fun f= ()->System.out.println("dhiraj prasad");
		Fun ff=()->{};
		List<String> list = Arrays.asList("sdfe","nirah","nirah","dhiraj","india");
		list.stream().distinct().forEach(System.out::println);
		list.stream().filter(var->{
			if(var.length()>3)
				return true;
			else 
				return false;
			}).collect(Collectors.toList());
		
		System.out.println("====================================================");
		list.stream().skip(0).forEach(System.out::println);
		System.out.println("==========================================================");
		List l =list.stream().map(var->var.equals("dhiraj")).collect(Collectors.toList());
		System.out.println(l);
		@SuppressWarnings("rawtypes")
		List ll = list.stream().filter(var->var.equals("dhiraj")&& var.length()==6).collect(Collectors.toList());
		ll.stream().forEach(System.out::println);
		f.fun();
		List<Integer> lt= Arrays.asList(21,2,3,4,1);
		System.out.println(lt);
		String s=list.stream().findAny().orElse("empty");
		System.out.println(s+"<<<<<<");
		
	}

}
