package com.dp.java.core;

import java.util.Comparator;
import java.util.HashMap;

public class Comp implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		int compare=o1.getRoll()-o2.getRoll();
		return compare;
	}

}
class Test {
	HashMap<String, String> map = new HashMap<>();
	void test(){
		System.identityHashCode(new Test());
	}
	
}
