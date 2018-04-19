package com.rajkiran.miscellaneous;

public class ReplaceQuestions {

	static void replaceString(int index,String s,char[] temp,int count){
		
		if(index>=s.length()){
			System.out.println(temp);
			return;
		}
		for(int i=index;i<s.length();i++){
			if(s.charAt(i)=='?' && count==0){
				temp[i]='0';
				replaceString(i+1,s,temp,count);
				temp[i]='1';
				replaceString(i+1,s,temp,count);
				count=1;
			}
			else{
				temp[i]=s.charAt(i);
			}
		}
		
	}
	public static void main(String[] args) {
		String s="101001???";
		char[] arr=new char[s.length()];
		replaceString(0,s,arr,0);
		
	}

}
