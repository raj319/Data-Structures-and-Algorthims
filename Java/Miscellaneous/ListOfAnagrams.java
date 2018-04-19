import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

class sortByString implements Comparator<StringBuffer>{
	int strcmp(StringBuffer x,StringBuffer y){
		if(x.length()<y.length()){
			return -1;
		}else if (x.length()>y.length()){
			return 1;
		}
		else{
			int i=0;
			int k=x.length();
			while(k>0){
				if(x.charAt(i)<y.charAt(i)){
					return -1;
				}else if(x.charAt(i)>y.charAt(i)){ 
					return 1;
				}
				k--;
				i++;
			}
			return 0;
		}
	}
	@Override
	public int compare(StringBuffer arg0, StringBuffer arg1) {
		
		int x=strcmp(arg0,arg1);
		return x;
	}
}
public class ListOfAnagrams {
	public static void sortIndividualUtil(StringBuffer arr,int l,int mid,int h){
		char[] L=new char[mid-l+1];
		char[] R=new char[h-mid];
		int n=mid-l+1;
		for(int i=0;i<n;i++){
			L[i]=arr.charAt(i+l);
		}
		int m=h-mid;
		for(int i=0;i<m;i++){
			R[i]=arr.charAt(i+mid+1);
		}
		int k,i,j;
		i=0;
		j=0;
		k=l;
		while(i<n && j<m){
			if(L[i]>R[j]){
				arr.setCharAt(k,R[j]);
				j++;
				k++;
			}else{
				arr.setCharAt(k,L[i]);
				i++;
				k++;
			}
		}
		while(i<n){
			arr.setCharAt(k,L[i]);
			i++;
			k++;
		}
		while(j<m){
			arr.setCharAt(k,R[j]);
			j++;
			k++;
		}
	}
	public static void sortIndividual(StringBuffer arr,int l,int h){
		
		if(l<h){
			int mid=(h+l)/2;
			sortIndividual(arr,l,mid);
			sortIndividual(arr,mid+1,h);
			sortIndividualUtil(arr,l,mid,h);
		}
	}
	
	public static void main(String[] args) {
		ArrayList<StringBuffer> l=new ArrayList<>();
		l.add(new StringBuffer("gdo"));
		l.add(new StringBuffer("cat"));
		l.add(new StringBuffer("dog"));
		l.add(new StringBuffer("tac"));
		l.add(new StringBuffer("god"));
		l.add(new StringBuffer("act"));
		ArrayList<KeepIndices> al=new ArrayList<>();
		int j=0;
		for(StringBuffer sb:l){
			al.add(new KeepIndices(sb,j));
			j++;
		}
		Iterator<KeepIndices> i=al.iterator();
		while(i.hasNext()){
			KeepIndices sb=(KeepIndices)i.next();
			sortIndividual(sb.sb,0,sb.sb.length()-1);
		}
		
		Collections.sort(al);
		for(KeepIndices ki:al){
			System.out.println(l.get(ki.index));
		}
	}
}
class KeepIndices implements Comparable<KeepIndices>{
	StringBuffer sb;
	int index;
	KeepIndices(StringBuffer sb,int index){
		this.sb=new StringBuffer(sb);
		this.index=index;
	}
	@Override
	public int compareTo(KeepIndices arg0) {
		// TODO Auto-generated method stub
		int x=new sortByString().strcmp(this.sb, arg0.sb);
		return x;
	}
}