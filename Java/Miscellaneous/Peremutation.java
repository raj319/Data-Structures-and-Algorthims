package com.rajkiran.miscellaneous;

public class Peremutation {

	public static void permute(String str,int l,int r){
		
		if(l==r){
			System.out.println(str);
		}else{
			for(int i=l;i<=r;i++){
				str = swap(str,l,i);
                permute(str, l+1, r);
                str = swap(str,l,i);
			}
		}
	}
	private static String swap(String re, int l, int i) {
		char[] temp=re.toCharArray();
		char temp1;
		temp1=temp[l];
		temp[l]=temp[i]; 
		temp[i]=temp1;
		return String.valueOf(temp);
	}
	public static void main(String[] args) {
		String res="abcd";
		permute(res,0,res.length()-1);
	}

}
