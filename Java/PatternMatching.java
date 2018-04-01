import java.util.LinkedList;
import java.util.List;

class Trie{
	boolean isLeaf;
	Trie[] child;
	Trie(){
		isLeaf=false;
		child=new Trie[26];
		for(int i=0;i<26;i++){
			child[i]=null;
		}
	}
}
public class PatternMatching {
	Trie root;
	public static void insert(Trie node,String x){
		for(int i=0;i<x.length();i++){
			int index=x.charAt(i)-97;
			if(node.child[index]==null){
				node.child[index]=new Trie();
			}
			node=node.child[index];
		}
		node.isLeaf=true;
	}
	
	public static boolean search(Trie t,String x){
		int index=0;
		for(int i=0;i<x.length();i++){
			index=x.charAt(i)-97;
			if(t.child[index]==null){
				System.out.println("did not find");
				return false;
			}
			t=t.child[index];
		}
		if(t.isLeaf==true)
		return true;
		return false;
	}
	public static void main(String[] args) {
		PatternMatching pm=new PatternMatching();
		pm.root=new Trie();
		insert(pm.root,"abcd");
		insert(pm.root,"abcde");
		insert(pm.root,"acbdeee");
		insert(pm.root,"abc");
		insert(pm.root,"abce");
		insert(pm.root,"adcab");
		System.out.println(search(pm.root,"acbdeee"));
	}

}
