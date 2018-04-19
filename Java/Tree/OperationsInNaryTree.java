package com.rajkiran.trees;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Nary{
	int data;
	List<Nary> child;
	Nary(int data){
		this.data=data;
		this.child=new ArrayList<>();
		
	}
}
public class OperationsInNaryTree {
	static int maxi=0;
	public static void printInorder(Nary node,List<Integer> path,int count){
		if(node.child.isEmpty()){
			maxi=Math.max(maxi, count);
			return;
		}
		Iterator<Nary> i=node.child.iterator();
		while(i.hasNext()){
			Nary temp=i.next();
			count++;
			printInorder(temp,path,count);
			count--;
		}
		
	}
	public static void main(String[] args) {
		Nary root=new Nary(10);
		root.child.add(new Nary(20));
		root.child.add(new Nary(30));
		root.child.add(new Nary(40));
		root.child.add(new Nary(50));
		Nary temp= root.child.get(2);
		temp.child.add(new Nary(31));
		temp.child.add(new Nary(32));
		temp.child.add(new Nary(33));
		temp.child.add(new Nary(34));
		temp= root.child.get(2).child.get(2);
		temp.child.add(new Nary(15));
		List<Integer> list=new ArrayList<>();
		printInorder(root,list,0);
		System.out.println(maxi);
	}

}
