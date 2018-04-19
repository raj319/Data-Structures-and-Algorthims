package com.rajkiran.miscellaneous;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.stream.*;
public class PersonalizedCoupons {
	public static void main(String[] args) throws IOException{
		Scanner input = new Scanner(System.in);
		List<String> preferredCategories = Arrays.asList(input.nextLine().split(","));
		List<Map<String, Object>> coupons = new ArrayList<>();
		int lines = Integer.parseInt(input.nextLine());
		IntStream.range(0, lines).forEach(i -> coupons.add(readCoupon(input)));
		List<Map<String, Object>> personalizedCoupons = personalizeCoupons(coupons, preferredCategories);
		personalizedCoupons.stream().forEach(PersonalizedCoupons::printCoupon);
	}
	public static List<Map<String, Object>> sort(List<Map<String, Object>> coupons)
	{

		int n = coupons.size();
		for (int i = n / 2 - 1; i >= 0; i--)
			heapify(coupons, n, i);
		List<Map<String, Object>> topItems=new ArrayList<>();
		int count=0;
		for (int i=n-1; i>=0; i--)
		{
			count++;
			if(count==11)break;
			int index=0;
			Map<String, Object> temp=new HashMap<>();
			temp = coupons.get(0);
			topItems.add(temp);
			coupons.set(index, coupons.get(i));
			coupons.set(i, temp);
			heapify(coupons, i, 0);
		}
		return topItems;
	}
	static void heapify(List<Map<String, Object>> coupons, int n, int i)
	{
		int largest = i; 
		int l = 2*i + 1;  
		int r = 2*i + 2;  
		if (l < n){
			float x=((float)coupons.get(l).get("couponAmount"))/(float)coupons.get(l).get("itemPrice"); 
			float y=((float)coupons.get(largest).get("couponAmount"))/(float)coupons.get(largest).get("itemPrice");
			if(x>y){
				largest = l;
			}
		}
			
		if (r < n){
			float x=((float)coupons.get(r).get("couponAmount"))/(float)coupons.get(r).get("itemPrice"); 
			float y=((float)coupons.get(largest).get("couponAmount"))/(float)coupons.get(largest).get("itemPrice");
			
			if(x>y){
				largest = r;
			}
			
		}
			
		if (largest != i)
		{
			Map<String, Object> temp=new HashMap<>();
			temp = coupons.get(i);
			coupons.set(i, coupons.get(largest));
			coupons.set(largest, temp);
			heapify(coupons, n, largest);
		}
	}
	
	static List<Map<String, Object>> personalizeCoupons1(List<Map<String, Object>> coupons, 
			List<String> preferredCategories) {
		List<Map<String,Object>> topItems=new ArrayList<>();
		for(Map<String,Object> coupon:coupons){
			String category=(String)coupon.get("category");
			int count1=0;
			for(String x:preferredCategories){
				if(x.equals(category))count1=1;
			}
			if(count1==0)continue;
			coupon.remove("code");
			coupon.put("HighestOff",((float)coupon.get("couponAmount"))/(float)coupon.get("itemPrice") );
			topItems.add(coupon);
		}
		Collections.sort(topItems,new Comparator<Map<String,Object>>(){
			@Override
			public int compare(Map<String,Object> o1, Map<String,Object> o2) {
				// TODO Auto-generated method stub
				if((float)o1.get("HighestOff")>(float)o2.get("HighestOff")){
					return -1;
				}else if((float)o1.get("HighestOff")<(float)o2.get("HighestOff")){
					return 1;
				}
				return 0;
			}
		});
		List<Map<String, Object>> finalTopItems=new ArrayList<>();
		int count=0;
		for(Map<String,Object> temp:topItems){
			if(count==10)break;
			finalTopItems.add(temp);
			count++;
		}
		return finalTopItems;
	}

	static List<Map<String, Object>> personalizeCoupons(List<Map<String, Object>> coupons, 
			List<String> preferredCategories) {
		Map<Map<String, Object>,Float> newItems=new HashMap<>();
		List<Map<String, Object>> topItems=new ArrayList<>();
		for(Map<String,Object> temp:coupons){
			String category=(String)temp.get("category");
			int count1=0;
			for(String x:preferredCategories){
				if(x.equals(category))count1=1;
			}
			if(count1==0)continue;
			float current=(float)temp.get("itemPrice");
			if(!newItems.isEmpty() && newItems.containsKey((Map<String,Object>)temp)){
				float prev=newItems.get(temp);
				if(!(prev<current)){
					continue;
				}
			}
			temp.remove("code");
			newItems.put(temp,current);
		}
		for (Map<String, Object> key : newItems.keySet()) {
			topItems.add(key);
		}
		
		return sort(topItems);
	}

	public static Map<String, Object> readCoupon(Scanner input) {
		String[] couponItems = input.nextLine().split(",");
		Map<String,Object> coupon = new HashMap<>();
		coupon.put("upc", couponItems[0]);
		coupon.put("code", couponItems[1]);
		coupon.put("category", couponItems[2]);
		coupon.put("itemPrice", Float.parseFloat(couponItems[3]));
		coupon.put("couponAmount", Float.parseFloat(couponItems[4]));
		return coupon;
	}
	public static void printCoupon(Map<String, Object> coupon)
	{
		System.out.print("{");
		System.out.print("\"couponAmount\":" +  coupon.get("couponAmount") + ",");
		System.out.print("\"upc\":\"" +  coupon.get("upc") + "\",");
		if(coupon.containsKey("code")) {
			System.out.print("\"code\":\"" +  coupon.get("code") + "\",");
		}
		System.out.print("\"itemPrice\":" +  coupon.get("itemPrice") + ",");
		System.out.println("\"category\":\"" +  coupon.get("category") + "\"}");
	}
}
