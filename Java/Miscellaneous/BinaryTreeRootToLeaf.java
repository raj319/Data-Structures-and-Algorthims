package com.rajkiran.miscellaneous;

import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;


public class BinaryTreeRootToLeaf {
	static class TreeNode{
		int data;
		TreeNode left;
		TreeNode right;
		TreeNode(int data){
			this.data=data;
			left=null;
			right=null;
		}
	}
	static TreeNode root;
	BinaryTreeRootToLeaf(){
		root=null;
	}

	static void printPath(TreeNode node,List<String> lal,String s){
		if(node.left==null|| node.right==null){
			s=s+node.data;
			lal.add(s);
			return;
		}
		s=s+node.data+"->";
		printPath(node.left,lal,s);
		printPath(node.right,lal,s);
		
		
	}
	public static void main(String[] args) {
		root=new TreeNode(1);
		root.left=new TreeNode(2);
		root.right=new TreeNode(3);
		root.left.left=new TreeNode(4);
		root.left.right=new TreeNode(5);
		root.right.left=new TreeNode(6);
		root.right.right=new TreeNode(1);
		List<String> lal=new ArrayList<String>();
		printPath(root,lal,"");
		for(String i:lal){
			System.out.println(i);
		}
	}
}
