package com.dp.main;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.dp.java.lambda.LambdaEx;

/**
 * @author dhiraj
 */
public class Main {

	public static void main(String[] args) {

		LambdaEx.lmbda();
		Stream<String> language =  Stream.of("tamil","telgu","hindi",null,"kannada");
		List<String> list =	language.filter(item->item!=null).collect(Collectors.toList());
		list.forEach(System.out::println);
	}

}
