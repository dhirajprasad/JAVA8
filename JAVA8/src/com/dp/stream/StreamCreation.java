package com.dp.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
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
	     
	     List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
	     numbers.stream().filter(n->n%2==0).collect(Collectors.toList()).forEach(System.out::println);
	     //find maximum number
	     List<Integer> intList = Arrays.asList(10, 20, 30, 40, 50);
	    int max =  intList.stream().mapToInt(Integer::intValue).max().getAsInt();
	    System.out.println(max);
	    //sort in descending order
	    List<Integer> nos = Arrays.asList(3, 5, 1, 4, 2);
	    nos.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()).forEach(System.out::print);
	    //count the word which starts with A
	    List<String> words = Arrays.asList("Alice", "Bob", "Annie", "Alex", "Charlie");
	    words.stream().filter(w->w.startsWith("A")).collect(Collectors.toList()).forEach(System.out::println);
	    //collect words with length greater than 5
	    words.stream().filter(w->w.length()>5).collect(Collectors.toList()).forEach(System.out::println);
	    String input = "swiss";
	    char cc = input.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(c->c,Collectors.counting())).entrySet()
	    .stream().filter(e->e.getValue()==1).map(e->e.getKey()).findFirst().get().charValue();
	    System.out.println(cc);
	    //Find Duplicate Elements in a List
	    List<Integer> d = Arrays.asList(1, 2, 3, 4, 2, 5, 1);
	    d.stream().collect(Collectors.groupingBy(i->i,Collectors.counting())).entrySet().stream()
	    .filter(e->e.getValue()>1).map(e->e.getKey()).collect(Collectors.toList()).forEach(System.out::println);
	    Set<Integer> set = new HashSet<>();
	    d.stream().filter(i->!set.add(i)).collect(Collectors.toSet()).forEach(System.out::println);
	    //Reverse Each String in a List
	    List<String> word = Arrays.asList("Java", "Stream", "API");
	    word.stream().map(e->new StringBuilder(e).reverse().toString()).collect(Collectors.toList()).forEach(System.out::println);
	    //Find the Most Frequent Character in a String maxby
	    String in = "success";
	    char cz = in.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(Function.identity(),Collectors.counting())).entrySet()
	    .stream().max(Map.Entry.comparingByValue()).map(e->e.getKey()).get().charValue();
	    in.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(Function.identity(),Collectors.counting())).entrySet()
	    .stream().max(Map.Entry.comparingByValue()).get();
	    System.out.println(cz);
	    largesetNumber();
	    int[] arr = {1,23,9,62,4,5,6,12};
	    reverse(arr);
	    int[] copy = reversedCopy(arr);
	    for(int i=0;i<copy.length;i++){
			System.out.print(" "+copy[i]);
		}
	    LargestConsecutiveSubarray();
	    LISWithSequence();
	}
	
	static void largesetNumber(){
		int[] arr = {1,23,9,62};
		String s =Arrays.stream(arr).boxed().map(String::valueOf).sorted((a,b)->(b+a).compareTo(a+b)).collect(Collectors.joining());
		System.out.println(Integer.valueOf(s));
		
	}
	// Return a new reversed array (non-destructive)
    public static int[] reversedCopy(int[] arr) {
        if (arr == null) return null;
        int n = arr.length;
        int[] out = new int[n];
        for (int i = 0; i < n; i++) {
            out[i] = arr[n - 1 - i];
        }
        
        return out;
    }

	static void reverse(int[] arr){
		// int[] arr = {1,23,9,62,4,5,6,12};
		int n = arr.length;
		int l=0,r=n-1;
		int temp;
		while(l<r){
			temp = arr[l];
			arr[l] = arr[r];
			arr[r] = temp;
			l++;
			r--;
			
		}
		for(int i=0;i<n;i++){
			System.out.println(arr[i]);
		}
	}
	static void rightRotation(){
		int[] arr = {1,23,9,62,4,5,6,12};
		int k=2;
		
		
	}	     
	static void LargestConsecutiveSubarray () {
        int[] arr = {1, 56, 57, 58, 2,5, 3, 4};
        int n = arr.length;
        int maxLen = 0;
        int startIndex = 0;

        for (int i = 0; i < n; i++) {
            int min = arr[i], max = arr[i];
            Set<Integer> set = new HashSet<>();
            set.add(arr[i]);

            for (int j = i + 1; j < n; j++) {
                if (set.contains(arr[j])) break; // duplicate → not valid
                set.add(arr[j]);

                min = Math.min(min, arr[j]);
                max = Math.max(max, arr[j]);

                if (max - min + 1 == j - i + 1) {
                    if (j - i + 1 > maxLen) {
                        maxLen = j - i + 1;
                        startIndex = i;
                    }
                }
            }
        }

        System.out.println("Length of largest consecutive subarray: " + maxLen);
        System.out.print("Subarray: ");
        for (int k = startIndex; k < startIndex + maxLen; k++) {
            System.out.print(arr[k] + " ");
        }
    }
	 public static void LongestConsecutiveSubsequence() {
	        int[] arr = {100, 4, 200, 1, 3, 2};
	        Set<Integer> set = new HashSet<>();
	        for (int num : arr) set.add(num);

	        int longest = 0;
	        List<Integer> bestSequence = new ArrayList<>();

	        for (int num : set) {
	            if (!set.contains(num - 1)) { // start of sequence
	                int current = num;
	                List<Integer> tempSeq = new ArrayList<>();
	                tempSeq.add(current);

	                while (set.contains(current + 1)) {
	                    current++;
	                    tempSeq.add(current);
	                }

	                if (tempSeq.size() > longest) {
	                    longest = tempSeq.size();
	                    bestSequence = tempSeq;
	                }
	            }
	        }

	        System.out.println("Longest consecutive subsequence length: " + longest);
	        System.out.println("Sequence: " + bestSequence);
	    }
	 void LongestIncreasingSubarray(){
		 int[] arr = {1, 2, 3, 2, 5, 6, 7};
	        int maxLen = 1, tempLen = 1;
	        int index = 0, tempindex = 0;

	        for (int i = 1; i < arr.length; i++) {
	            if (arr[i] > arr[i-1]) {
	                tempLen++;
	            } else {
	                tempLen = 1;
	                index = i;
	            }

	            if (tempLen > maxLen) {
	                maxLen = tempLen;
	                tempindex = index;
	            }
	        }

	        System.out.println("Length of longest increasing subarray: " + maxLen);
	        System.out.print("Subarray: ");
	        for (int i = tempindex; i < tempindex + maxLen; i++) {
	            System.out.print(arr[i] + " ");
	 }
}
	 
	static void  LISWithSequence(){
		int[] arr = {10, 22, 9, 33, 21, 50, 41, 60};
        int n = arr.length;
        int[] dp = new int[n];
        int[] tracing = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(tracing, -1);

        int maxLen = 1, lastIndex = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    tracing[i] = j;
                }
            }
            if (dp[i] > maxLen) {
                maxLen = dp[i];
                lastIndex = i;
            }
        }

        // Reconstruct sequence
        List<Integer> sequence = new ArrayList<>();
        while (lastIndex != -1) {
            sequence.add(arr[lastIndex]);
            lastIndex = tracing[lastIndex];
        }
        Collections.reverse(sequence);

        System.out.println("Length of LIS: " + maxLen);
        System.out.println("Sequence: " + sequence);
		 
	 }
}
