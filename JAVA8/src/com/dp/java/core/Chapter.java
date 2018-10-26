package com.dp.java.core;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Chapter {
	
	public static void lessonOne(){
		List<String> elements =
				  Stream.of("a", "b", "c").filter(element -> !element.contains("z"))
				    .collect(Collectors.toList());
				Optional<String> anyElement = elements.stream().findAny();
				Optional<String> firstElement = elements.stream().findFirst();
				System.out.println("any element "+anyElement.get());
				System.out.println("any element "+firstElement.get());
				elements.forEach(System.out::println);
				

	}
	public static void lessonTwo(){
		
	}

}
