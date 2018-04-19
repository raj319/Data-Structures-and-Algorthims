package com.rajkiran.miscellaneous;

public class MaximumSquares {
	public static int findOnes(int[][] arr,int m,int n){
		int[][] dp=new int[m][n];
		int maxResult=0;
		for(int i=0;i<n;i++){
			if(arr[0][i]==1)maxResult=1;
			dp[0][i]=arr[0][i];
		}
			
		for(int i=0;i<m;i++){
			if(arr[i][0]==1)maxResult=1;
			dp[i][0]=arr[i][0];
		}
		for(int i=1;i<m;i++){
			for(int j=1;j<n;j++){
				if(arr[i][j]==0){
					dp[i][j]=0;
					continue;
				}
				dp[i][j]=Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]))+1;
				maxResult=Math.max(maxResult, dp[i][j]);
			}
		}
		
		return maxResult;
	}
	public static void main(String args[]){
		int[][] arr=new int[][]{{0,0,0,0,1},
								{0,1,1,1,1},
								{0,1,1,1,1},
								{0,1,1,1,1},
								{0,1,1,1,1}};
		int m=5,n=5;
		int result=findOnes(arr,m,n);
		System.out.println(result);
	}
}