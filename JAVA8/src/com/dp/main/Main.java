package com.dp.main;

import java.util.Scanner;

import com.dp.entity.Student;
import com.dp.java.core.OverloadingAutoBoxing;
import com.dp.util.Helper;

/** 
 * @author dhiraj
 */

public class Main {
	public static void main(String[] args) {
		OverloadingAutoBoxing c = new OverloadingAutoBoxing();
		Student object = new Student();
		object.setName("heloo");
		//Helper.serializ(object);
		Helper.deserializ();
		System.out.println("done");
	}		
}
