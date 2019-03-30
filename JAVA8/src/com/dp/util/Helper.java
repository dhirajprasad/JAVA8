package com.dp.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.swing.JFileChooser;

import com.dp.entity.Student;
import com.dp.java.core.Chapter;
import com.dp.java.lambda.LambdaEx;

public class Helper {

	static void helper(){
		HashMap<String, String> hashmap = new HashMap<>();
		System.out.println("calling  say loud");
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
		System.out.println();
		String name1 = "dhiraj";
		String obj = Objects.requireNonNull(name1,"cant be null");
		System.out.println(">>>>name <<<<"+obj);
		Stream<Object> s =Stream.builder().add("dhiraj prasd").build();
		Chapter.lessonOne();
		Chapter.lessonTwo();
	}
	static <T> void swapNumber(T a ,T b){
		
	}
	/**
	 * method for finding maximum number from array 
	 * @param arr
	 * @return
	 */
	public static int findMax(int[] arr){
		int max = arr[0];
		for (int i=1;i<arr.length;i++){
			if(arr[i]>max){
				max = arr[i];
			}
		}
		return max;
	}
	/**
	 * method for finding minimum number from array of type int
	 * @param arr
	 * @return
	 */
	public static int finMin(int[] arr){
		int min=arr[0];
		for(int i=1;i<arr.length;i++){
			if(arr[i]<min){
				min = arr[i];
			}
		}
		return min;
	}
	/**
	 * @param arr
	 * @param key
	 * binary search 
	 */
	public static void  bnarySearch(int[] arr,int key){
		int first = 0;
		int last = arr.length - 1;
		int mid = (first + last)/2;
		while(first <= last){
			if(mid == key ){
				System.out.println(key);
				break;
			}
			if(key<mid){
				last = last-1;
			}
			if(key > mid){
				first = first +1;
			}
			mid = (first + last)/2;
		}
		
	}

	public  static void write(byte[] stream ){
		String pa= new JFileChooser().getFileSystemView().getDefaultDirectory().toString();
		String path =pa+"\\temp.pdf";
		File file = new File(path);
		FileOutputStream out = null;
		try {
			out = new FileOutputStream(file);
			out.write(stream);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(out!=null){
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

	public static void serializ(Object object){
		String pa= new JFileChooser().getFileSystemView().getDefaultDirectory().toString();
		String path  =pa+"\\temp.ser";
		File file = new File(path);
		try(FileOutputStream fileout = new FileOutputStream(file);
			ObjectOutputStream out = new ObjectOutputStream(fileout);){
			out.writeObject(object); 
            System.out.println("Object has been serialized"); 
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
				
	}
	public static void deserializ(){
		String docPath= new JFileChooser().getFileSystemView().getDefaultDirectory().toString();
		String path  =docPath+"\\temp.ser";
		File file = new File(path);
		try (FileInputStream inputStream = new FileInputStream(file);
			ObjectInputStream objstream = new ObjectInputStream(inputStream)){
			Student  obj = (Student) objstream.readObject();
			String name =obj.getName();
			int roll = obj.getRoll();
			System.out.println("name "+name +" roll>"+roll);
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
