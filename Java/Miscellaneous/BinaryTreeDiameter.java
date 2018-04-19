package com.rajkiran.miscellaneous;

import java.net.SocketTimeoutException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class BinaryTreeDiameter {
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
	BinaryTreeDiameter(){
		root=null;
	}

	static int findDepth(TreeNode node){
		if(node==null)return 0;
		return 1+Math.max(findDepth(node.left),findDepth(node.right));
	}
	static int findDiameter(TreeNode node){
		int l=findDepth(node.left);
		int r=findDepth(node.right);
		System.out.println(l+" "+r);
		return l+r;
	}
	public static int diameterOfBinaryTree(TreeNode root) {
		Queue<TreeNode> q=new LinkedList<>();
		if(root==null)return 0;
		q.add(root);
		TreeNode temp=null;
		int maxi=0;
		while(!q.isEmpty()){
			temp=q.poll();
			maxi=Math.max(maxi,findDiameter(temp));
			System.out.println(maxi);
			if(temp.left!=null)q.add(temp.left);
			if(temp.right!=null)q.add(temp.right);
		}
		return maxi;
	}
	public static void main(String[] args) {
		root=new TreeNode(1);
		root.left=new TreeNode(2);
		root.right=new TreeNode(3);
		root.left.left=new TreeNode(4);
		root.left.right=new TreeNode(5);
		root.right.left=new TreeNode(6);
		root.right.right=new TreeNode(1);
		System.out.println(diameterOfBinaryTree(root));
	}
}
