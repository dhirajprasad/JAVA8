package com.dp.serviceImpl;

import com.dp.service.MatrixOperation;

public class MatrixoperationImpl implements MatrixOperation {

	@Override
	public void sprialPattern(int[][] arr) {

		int sum =0;
		for(int i=0;i<arr.length;i++){
			for(int j=0; j< arr[i].length ;j++){
				if(i == j){
					sum = sum + arr[i][j];
				}
				
			}
			
		}
		System.out.println("sum" + sum);
	}

}
