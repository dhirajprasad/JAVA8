package com.dp.java.core;

import java.util.Comparator;

public class Comp implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		int compare=o1.getRoll()-o2.getRoll();
		return compare;
	}

	

}
