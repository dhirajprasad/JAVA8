package com.dp.java.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.dp.java.core.Comp;
import com.dp.java.core.Student;



/**
 * @author M1029440
 *
 */
public class LambdaEx {

	public static void lmbda(){
		List<Student> studentList=new ArrayList<>();
		studentList.add(new Student("Dhiraj", 4));
		studentList.add(new Student("Ajay", 450));
		studentList.add(new Student("Niraj", -1));
		/*
		 * prior to java 8 this is how we sort the list 
		 */
		Collections.sort(studentList, new Comp());
		System.out.println(studentList);
		/*
		 * in java 8 using lambda expression this is how we sort list
		 */
		Comparator<Student> c=(Student s1,Student s2)->{
			return s2.getRoll() -s1.getRoll();
			
		};
		
		/*
		 * The compiler automatically returns the value if the body has a single expression to return the value.
		 *  Curly braces are required to indicate that expression returns a value.
		 */
		Comparator<Student> comparator=( s1, s2)->s2.getRoll() -s1.getRoll();
		/*
		 * without type declaration 
		 */
		Collections.sort(studentList, ( s1, s2)->{
			return s1.getRoll() - s2.getRoll();
			
		});
		
		System.out.println(studentList);
		studentList.sort(c);
		System.out.println(studentList);
	}
}
