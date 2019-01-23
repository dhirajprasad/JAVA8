package com.dp.main;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.dp.java.core.Chapter;
import com.dp.java.lambda.LambdaEx;

/**
 * @author dhiraj
 */


interface Sayable{  
    void say(String s);  
    default void dontSay(){
    	System.out.println("dont say any thing ");
    }
    default void sayLoud(){
    	System.out.println("dont say any thing ");
    }
}  
class MethodReference {  
    static void saySomething(String s ){  
       System.out.println("Hello, this is static method."+ s);  
   }
    void met(Mathsq m){
    	m.add();
    }
}
public class Main {

	public static void main(String[] args) {

		HashMap<String, String> hashmap = new HashMap<>();
		Sayable sa = MethodReference::saySomething;
		sa.dontSay();
		sa.sayLoud();
		LambdaEx.lmbda();
		String name = "dhiraj";
		Stream<String> language =  Stream.of("tamil","telgu","hindi",null,"kannada");
		//List<String> list =	language.filter(item->item!=null).collect(Collectors.toList());
	//	list.forEach(System.out::println);
		List<String> result = language.filter(Objects::nonNull).collect(Collectors.toList());
		result.forEach(System.out::println);
		Stream<String> na = Stream.of(name).filter(Objects::nonNull);
		Optional<String> o = Optional.of(name).filter(Objects::nonNull);
		System.out.println(o.get());
		na.forEach(System.out::println);
		Stream<Object> stream = Stream.of("dhiraj");
		Sayable sayable = MethodReference::saySomething; 
		sayable.say("String example ");
		System.out.println();
		Add add = new Add();
		Mathsq m = add::add;
		int resut = m.add(2,3);
		System.out.println(resut);
		String name1 = "dhiraj";
		String obj = Objects.requireNonNull(name1,"cant be null");
		System.out.println(">>>>name <<<<"+obj);
		Stream<Object> s =Stream.builder().add("dhiraj prasd").build();
		Chapter.lessonOne();
		Chapter.lessonTwo();
	}

}
@FunctionalInterface
interface Mathsq{
	int add(int ...a);
}


class Add{
	int add(int ... a){
		int sum=0;
		for (int i = 0; i < a.length; i++) {
			sum = sum+a[i];
		}
		return sum;
	}
}