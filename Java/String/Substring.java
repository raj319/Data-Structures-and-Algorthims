package com.rajkiran.strings;

public class Substring {

	public static void main(String[] args) {
		String a="bcdefagasdsadasdsajunhudifadjchabxcilnasjkcsancjasnsdkjknajksdns";
		String b="bcdefagasdsadasdsajunhudifadjchabxcilnasjkcsancjasnsdkjknajksd";
		System.out.println(isSubstring(a,b));
	}

	private static boolean isSubstring(String a, String b) {
		int[] arr=new int[b.length()];
		prefixBuild(b,arr);
		int j=0;
		for(int i=0;i<a.length();i++){
			if(a.charAt(i)==b.charAt(j)){
				j++;
				if(j==b.length())return true;
			}else if(j<=0){
				j=0;
			}
			else{
				j=arr[j-1];
			}
		}
		return false;
	}

	private static void prefixBuild(String b,int[] arr) {
		int i=1;
		int j=0;arr[0]=0;
		while(i<b.length()){
			if(b.charAt(i)==b.charAt(j)){
				arr[i]=j+1;
				i++;
				j++;
			}else if(j>0){
				j=arr[j-1];
			}else{
				arr[i]=0;
				i++;
			}
		}
	}

}
