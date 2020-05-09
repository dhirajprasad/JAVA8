package com.dp.main;

import java.util.Comparator;
import java.util.List;

import com.dp.entity.Book;
import com.dp.util.Helper;

/**
 * @author dhiraj
 */

public class Main {
	static int removeDuplicates(int arr[], int n) {
		if (n == 0 || n == 1)
			return n;

		// To store index of next unique element
		int j = 0;

		// Doing same as done in Method 1
		// Just maintaining another updated index i.e. j
		for (int i = 0; i < n - 1; i++)
			if (arr[i] != arr[i + 1])
				arr[j++] = arr[i];

		arr[j++] = arr[n - 1];

		return j;
	}

	static void add(List list, Book book) {

		if (list.contains(book)) {
			System.out.println("books all ready presnt in the list ");
		} else {
			list.add(book);
		}
	}

	public static void main(String[] args) {
		 int arr[] = {23,23,1, 2, 2, 3, 4, 4, 4, 5, 5}; /*Arrays.sort(arr);*/
		 Helper.findSubarray(arr, 11);
	        int len = arr.length; 
	        int n = removeDuplicates(arr, len); 
	        for (int i=0; i<len; i++) 
	            System.out.print(arr[i]+" ");
	        
	   

	}
}

class BookComparator implements Comparator<Book> {

	@Override
	public int compare(Book b1, Book b2) {
		return (int) (b2.getPrice() - b1.getPrice());
	}

}