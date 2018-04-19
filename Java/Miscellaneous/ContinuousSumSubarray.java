package com.rajkiran.miscellaneous;

public class ContinuousSumSubarray {

	private static void subarray(int[] arr,int n){
		
		int current_max=arr[0];
		int sum_below_n=arr[0];
		for(int i=1;i<arr.length;i++){
			current_max=Math.max(arr[i], current_max+arr[i]);
			if(Math.abs(sum_below_n-n) > Math.abs(current_max-n)){
				sum_below_n=current_max;
			}
			if(Math.abs(sum_below_n-n) > Math.abs(arr[i]-n)){
				sum_below_n=arr[i];
			}
		}
		System.out.println(sum_below_n);
	}
	public static void main(String[] args) {
		
		int[] arr=new int[]{-2,11,-4,13,-5,2};
		int n=10;
		subarray(arr,n);
//		System.out.println(sum_below_n);
//		aqa
		
	}

}
