package com.dp.datastructure;

import java.util.ArrayList;
import java.util.List;

public class ReverseSentence {

	public static void findFrequency(int[] A) {
		// create a count array of size n to store count of all array elements
		int[] freq = new int[A.length];

		// update frequency of each element
		for (int e : A) {
			freq[e]++;
		}

		// iterate through the array to print frequencies
		for (int i = 0; i < A.length; i++) {
			if (freq[i] > 0) {
				System.out.printf("%d appears %d times\n", i, freq[i]);
			}
		}
	}
	public static String replaceRepeating(String str ,char c){
		List<Character> list = new ArrayList<>();  
		String result="";
		int len = str.length();
		for (int i=0;i<len;i++){
			Character ch= str.charAt(i);
			if(result.indexOf(ch)< 0){
				result = result + ch;
			}else{
				list.add(ch);
			}
		}
		for(int i=0;i<list.size();i++){
			Character cr=list.get(i);
			str = str.replace(Character.toLowerCase(cr), c);
			str = str.replace(Character.toUpperCase(cr), c);
		}
		return str;
	}
	public static void main(String[] args) {

		int[] A = { 2, 3, 3,5 ,1,2, 1 };
		findFrequency(A);
		String s=replaceRepeating("Krishnan Aravind",'*');
		//System.out.println(s);
		Integer i = new Integer(33);
		Integer ii = new Integer(12);
		System.out.println(i.hashCode()>>1);
		System.out.println(ii.hashCode()>>2);
		int a[] = new int[1];
		a[0]=8;
		++a[0];
		System.out.println(a[0]);
		
    }
	}


