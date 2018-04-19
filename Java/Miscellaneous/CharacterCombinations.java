package com.rajkiran.miscellaneous;
import java.util.ArrayList;
import java.util.List;

public class CharacterCombinations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<ArrayList<Character>> l=new ArrayList<>();
		ArrayList<Character> al=new ArrayList<>();
		al.add('a');
		al.add('b');
		al.add('c');
		l.add(al);
		al=new ArrayList<>();
		al.add('d');
		al.add('e');
		l.add(al);
		al=new ArrayList<>();
		al.add('f');
		al.add('g');
		l.add(al);
		printPath(l,0,"");
	}

	private static void printPath(List<ArrayList<Character>> l,int level,String path) {
		
		if(level>=l.size()){
			System.out.println(path);
			return;
		}
		ArrayList<Character> a=l.get(level);
		for(Character x:a){
			path=path+x;
			printPath(l,level+1,path);
			path=path.substring(0,path.length()-1);
		} 
		
		
	}

}
