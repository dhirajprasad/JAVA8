package com.dp.java.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.dp.java.core.Comp;
import com.dp.java.core.Student;



/**
 * @author M1029440
 *
 */
public class LambdaEx {
	public static void main(String[] args) {
		//1.find max pallindrome
		List<String> list =Arrays.asList("madam","racecar","apple","banana","level");
		String ma=list.stream().filter(s->s.equals(new StringBuilder(s).reverse().toString())).max(Comparator.comparingInt(String::length)).get();
		System.out.println(ma);
		
		//2 find the longest word in a sent
		String sen = "my name is Dhiraj prs";
		String s = Arrays.stream(sen.split(" ")).max(Comparator.comparingInt(String::length)).get();
		System.out.println(s);
		List<Integer> intlist =Arrays.asList(1,2,3,4,5,6,7,8,9);
		intlist.stream().filter(n->IntStream.rangeClosed(2,n).noneMatch(i->n%i==0)).mapToInt(Integer::intValue).sum();
		lmbda();
	}

	public static void lmbda(){
		List<Student> list=new ArrayList<>();
		list.add(new Student("Dhiraj", 5));
		list.add(new Student("Ajay", 450));
		list.add(new Student("Niraj", 1));
		list.add(new Student("w", 341));
		double dd = list.stream().map(item->item.getRoll()).collect(Collectors.averagingDouble(roll->roll)).doubleValue();
		System.out.println(dd);
		Map<String,Student> map1 = list.stream().collect(Collectors.toMap(Student::getName, Function.identity()));
		
		Map<String,Student> map = list.stream().collect(Collectors.toMap(item->item.toString(), Function.identity()));
		
		System.out.println(">>>>"+map);
		/*
		 * prior to java 8 this is how we sort the list 
		 */
		Collections.sort(list, new Comp());
		System.out.println(list);
		/*
		 * in java 8 using lambda expression this is how we sort list
		 */
		Comparator<Student> c=(Student s1,Student s2)->{
			return s2.getRoll() -s1.getRoll();//
			
		};
		
		/*
		 * The compiler automatically returns the value if the body has a single expression to return the value.
		 *  Curly braces are required to indicate that expression returns a value.
		 */
		Comparator<Student> comparator=( s1, s2)->s2.getRoll() -s1.getRoll();
		/*
		 * without type declaration  
		 */
		Collections.sort(list, ( s1, s2)->{
			return s1.getRoll() - s2.getRoll();
			
		});
		
		System.out.println(list);
		list.sort(c);
		System.out.println(list);
		List<Integer> lt = Arrays.asList(5, 8, 2, 9, 1, 9);//second largest number
		Integer i = lt.stream().sorted(Comparator.comparingInt(Integer::intValue).reversed()).distinct().skip(1).findFirst().get();
		System.out.println(i);
		//find the occurence more than one 
		List<Integer> oc = Arrays.asList(1,2,3,2,4,5,1,6);
		List<Integer> lk = oc.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting())).entrySet().stream()
		.filter(e->e.getValue()>1).map(e->e.getKey()).collect(Collectors.toList());
		System.out.println(lk);
		List<Integer> d = Arrays.asList(4,5,6,4,7,5);
		Integer in = d.stream().collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new ,Collectors.counting())).entrySet()
		.stream().filter(e->e.getValue()==1).map(e->e.getKey()).findFirst().get();
		System.out.println(in);
		
		  int[] arr = {100,4,200,1,3,2,10};

	        Set<Integer> set = Arrays.stream(arr)
	                .boxed()
	                .collect(Collectors.toSet());

	        int longest = set.stream()
	                .filter(n -> !set.contains(n - 1))
	                .mapToInt(n -> {
	                    int current = n;
	                    int count = 1;

	                    while (set.contains(current + 1)) {
	                        current++;
	                        count++;
	                    }
	                    return count;
	                })
	                .max()
	                .orElse(0);

	        System.out.println(longest);
	        
	        int[] arr1 = {10,9,2,5,3,7,101,18};
	        int n = arr.length;

	        int[] dp = new int[n];
	        Arrays.fill(dp, 1);

	        for(int a = 1; a < n; i++) {
	            for(int j = 0; j < i; j++) {

	                if(arr1[a] > arr1[j]) {
	                    dp[a] = Math.max(dp[a], dp[j] + 1);
	                }

	            }
	        }

	        int longestl = Arrays.stream(dp).max().getAsInt();

	        System.out.println("Length = " + longestl);
		
	}
}
