package com.rajkiran.miscellaneous;
import java.net.SocketTimeoutException;
import java.util.LinkedList;
import java.util.Stack;


public class MaximumElement {
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
	MaximumElement(){
		root=null;
	}
	static void print(TreeNode node){
		if(node==null)return;
		print(node.left);
		System.out.println(node.data);
		print(node.right);
	}
	static int max(int a, int b,int c){
		if(a>b){
			if(a>c){
				return a;
			}else{
				return c;
			}
		}else{
			if(b>c){
				return b;
			}else{
				return c;
			}
		}
	}
	static int findMaxWithRecur(TreeNode node){
		if(node==null)return 0;
		int left=findMaxWithRecur(node.left);
		int right=findMaxWithRecur(node.right);
		return max(left,node.data,right);
	}
	static int findMaxWithoutRecur(TreeNode root){
		Stack<TreeNode> s=new Stack<>();
		int max=-1;
		while(root!=null){
			s.push(root);
			root=root.left;
		}
		while(!s.isEmpty()){
			TreeNode temp=s.pop();
			if(temp.data>max)max=temp.data;
			if(temp.right!=null){
				temp=temp.right;
				while(temp!=null){
					s.push(temp);
					temp=temp.left;
				}
			}
		}
		return max;
	}
	public static void main(String[] args) {
		root=new TreeNode(1);
		root.left=new TreeNode(2);
		root.right=new TreeNode(3);
		root.left.left=new TreeNode(4);
		root.left.right=new TreeNode(5);
		root.right.left=new TreeNode(6);
		root.right.right=new TreeNode(1);
		System.out.println(findMaxWithoutRecur(root));
		System.out.println(findMaxWithRecur(root));
	}
}
