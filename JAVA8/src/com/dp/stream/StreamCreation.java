package com.dp.stream;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.dp.entity.Student;

/**
 * A stream does not store data and, in that sense, is not a data structure.
 * It also never modifies the underlying data source.
 */
public class StreamCreation {

	public static void main(String[] args) {
		Student[] arrayOfEmps = { new Student("Dhiraj",1), new Student("niraj",3),new Student("vihar",2)};
		Stream<Student> stream = Stream.of(arrayOfEmps);
		//stream.forEach((s)->System.out.println(s));
		List<Integer> list = Arrays.asList(1,2,3,4);
		Iterator<Integer> it = list.iterator();
		while (it.hasNext()){
			System.out.println(it.next());
		}
		list.stream().forEach(System.out::print);
		List<Student> listS =stream.peek(item->item.getName().toUpperCase()).peek(System.out::println).collect(Collectors.toList());
		System.out.println(listS+">>");
		
		 Map<Integer, String> hmap = new HashMap<Integer, String>();
	      hmap.put(1, "ABC");
	      hmap.put(2, "XCB");
	      hmap.put(3, "ABB");
	      hmap.put(4, "ZIO");

	      Map<Integer, String> result = hmap.entrySet()
	         .stream()
	         .filter(p -> p.getKey().intValue() <= 3) //filter by key
	         .filter(map -> map.getValue().startsWith("A")) //filter by value
	         .collect(Collectors.toMap(map -> map.getKey(), map -> map.getValue()));

	     System.out.println("Result: " + result);
	}

}
