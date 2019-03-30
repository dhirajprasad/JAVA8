package com.dp.main;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class streamEx {

	public static void main(String[] args) {

		Map<String, Integer> strMap = new HashMap<String, Integer>();
		strMap.put("one", 1);
		strMap.put("two", 88);
		strMap.put("three",6);
		strMap.put("xis", 7);
		//Keyset example 
		Set<String> set = strMap.keySet();
		Iterator<String> strItr = set.iterator();
		while (strItr.hasNext()){
			System.out.println(strItr.next());
		}
		
		//Entry set
		for (Map.Entry<String, Integer> string : strMap.entrySet()) {
			System.out.println(string.getKey()+"<>" + string.getValue());
			
		}
		
		
	}

}
