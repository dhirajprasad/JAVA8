package com.dp.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.dp.entity.Student;
import com.dp.java.core.OverloadingAutoBoxing;
import com.dp.java.lambda.LambdaEx;
import com.dp.service.ArrayOperation;
import com.dp.serviceImpl.ArrayOperationImpl;
import com.dp.util.Helper;

/** 
 * @author dhiraj
 */

public class Main {
	public static void main(String[] args) {
		 List<String> list = new ArrayList();
		 list.add("eagle");
		 list.add("string");
		 list.add("dog");
		 list.add("cat");
		 Iterator<String> siterator = list.iterator();
		 Hashtable<String, String> g;
		 while (siterator.hasNext()) {
			String string = (String) siterator.next();
			System.out.println(string);
			
		}
		 Collections.sort(list);
		 System.out.println(Collections.binarySearch(list, "eagle"));
		 Comparator<String> rev =(obj1,obj2)->{
			 return obj2.compareTo(obj1);
		 };
		 Set<String> stringSet = new HashSet<>();
		 stringSet.add("String");
		Set l= list.stream().filter((item)->item.equals("dog")).collect(Collectors.toSet());
		System.out.println("---------------------------------");
		list =list.stream().map(item->{
			return item.toUpperCase();
		}).collect(Collectors.toList());
		list.forEach(System.out::println);
	}		
}
