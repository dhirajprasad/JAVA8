package com.dp.serviceImpl;

import java.util.Arrays;

import com.dp.service.ArrayOperation;

public class ArrayOperationImpl implements ArrayOperation {

	@Override
	public void seprateZero(int[] inputArray) {
		int counter = 0;
        //Traversing inputArray from left to right
        for (int i = 0; i < inputArray.length; i++){
            //If inputArray[i] is non-zero
            if(inputArray[i] != 0){
                //Assigning inputArray[i] to inputArray[counter]
                inputArray[counter] = inputArray[i];
                //Incrementing the counter by 1
                counter++;
            }
        }
        //Assigning zero to remaining elements
        while (counter < inputArray.length){
            inputArray[counter] = 0;
            counter++;
        }
        System.out.println(Arrays.toString(inputArray));

		
	}

	@Override
	public void mvZeroFront(int[] arr) {
		int counter = arr.length-1;
		for (int i=arr.length-1;i>=0;i--){
			if(arr[i]!=0){
				arr[counter] = arr[i];
				counter--;
			}
		}
		while(counter>=0){
			arr[counter]=0;
			counter--;
		}
		System.out.println(Arrays.toString(arr));
		
	}

	@Override
	public void seprateZeroAndOne(int[] arr) {
		seprateZero(arr);
	}

	@Override
	public void seprateEvenAndOdd(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			   int left=0;
			   int right=arr.length-1;
			   while(arr[left]%2==0){
			    left++;
			   }
			   while(arr[right]%2==1){
			    right--;
			   }
			   if(left<right){
			    int temp=arr[left];
			    arr[left]=arr[right];
			    arr[right]=temp;
			   }
			   
			  }
			  System.out.println(Arrays.toString(arr));
			 }

	@Override
	public void removeDuplicate(int[] arr) {
		int len = arr.length;
		int[] temp = new int[len]; 
		if(len==0||len == 1){
			System.out.println("final array >>"+arr);
		}
		int j=0;
		for(int i=0;i<len-1;i++){
			if(arr[i]!=arr[i+1]){
				temp[j]=arr[i];
				j++;
			}
		}
		 temp[j++] = arr[len-1]; 
		for (int i=0; i<j; i++) 
            arr[i] = temp[i]; 
		for (int i : arr) {
			System.out.print(" "+i);
		}
		System.out.println();
		for (int i : temp) {
			System.out.print(" "+i);
		}
		
	}
	}

