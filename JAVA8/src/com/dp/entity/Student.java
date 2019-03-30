package com.dp.entity;

import java.io.Serializable;

public class Student implements Comparable<Student>,Serializable{
	
	private static final long serialVersionUID = 1L;
	private String name;
	private int roll;
	 
	 public Student() {
		 System.out.println("default constructor"+Student.class.getCanonicalName());  
	}
	 
	public Student(String name, int roll) {
		super();
		this.name = name;
		this.roll = roll;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRoll() {
		return roll;
	}
	public void setRoll(int roll) {
		this.roll = roll;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", roll=" + roll + "]";
	}


	@Override
	public int compareTo(Student o) {
		return this.name.compareTo(o.getName());
	}
	

}
