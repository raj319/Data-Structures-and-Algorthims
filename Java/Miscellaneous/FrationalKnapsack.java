package com.rajkiran.miscellaneous;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class knap{
	int cap;
	int weight;
	knap(int cap,int weight){
		this.cap=cap;
		this.weight=weight;
	}
}
class MyComparator implements Comparator<knap>{

	@Override
	public int compare(knap arg0, knap arg1) {
		// TODO Auto-generated method stub
		if( arg0.cap/arg0.weight<arg1.cap/arg1.weight){
			return 1;
		}else if( arg0.cap/arg0.weight>arg1.cap/arg1.weight){
			return -1;
		}
		return 0;
	}
	
}
public class FrationalKnapsack {

	public static void main(String[] args) {
		int knapCapacity=4;
		int result=0;
		List<knap> knaps=new ArrayList<>();
		knap k1=new knap(100,2);
		knap k2=new knap(10,2);
		knap k3=new knap(120,3);
		knaps.add(k1);
		knaps.add(k2);
		knaps.add(k3);
		
		Collections.sort(knaps,new MyComparator());
		for(knap k:knaps){
			System.out.println(k.cap+" "+k.weight);
			if(k.weight<=knapCapacity){
				knapCapacity=knapCapacity-k.weight;
				result=result+k.cap;
			}else{
				if(knapCapacity==0)
				break;
				else{
					result=result+(k.cap/k.weight)*knapCapacity;
					knapCapacity=0;
				}
			}
		}
		System.out.println(result);
	}

}
