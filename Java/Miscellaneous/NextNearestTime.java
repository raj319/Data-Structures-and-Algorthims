package com.rajkiran.miscellaneous;
import java.util.ArrayList;
import java.util.List;

public class NextNearestTime {
	
	static int max=Integer.MAX_VALUE;
	static String result;
	static int ini;
    private static void permute(String str, int l, int r)
    {
        if (l == r)
        {
        	
        	int temp=Integer.parseInt(str);
        	if(temp>=2400)return;
        	if(temp/100>=24 || temp%100>=60)return;
        	System.out.println(temp+" "+ini);
        	int temp1=temp-ini;
        	if(temp1<0){
        		temp1=2400-ini+Math.abs(temp);
        	}
        	if(max>temp1 && temp1!=0){
        		max=temp1;
        		result=str;
        	}
        }
        else
        {
            for (int i = l; i <= r; i++)
            {
                str = swap(str,l,i);
                permute(str, l+1, r);
                str = swap(str,l,i);
            }
        }
    }
    public static String swap(String a, int i, int j)
    {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i] ;
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }
	
	
	
	public static void main(String[] args) {
		
		String time="10:50";
		String[] x=time.split(":");
		String re="";
		for(String i:x){
			re=re+i;
		}
		ini=Integer.parseInt(re);
		permute(re,0,3);
		if(result==null){
			result=time;
			System.out.println(result);
			return;
		}
		System.out.println(result);
		int resultTime=Integer.parseInt(result);
		String result="";
		result+=resultTime%100;
		result=":"+result;
		resultTime=resultTime/100;

		result=resultTime+result;
		System.out.println(result);
	}

}
