package com.rajkiran.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

class BTreeNode{
	int data;
	BTreeNode left;
	BTreeNode right;
	BTreeNode(int data){
		this.data=data;
		this.left=null;
		this.right=null;
	}
}
public class OperationsInBTree {
	public static BTreeNode insert(BTreeNode root,int data){

		if(root==null){
			root=new BTreeNode(data);		
			return root;
		}
		Queue<BTreeNode> s=new LinkedList<>();
		s.add(root);
		while(true){
			BTreeNode temp=s.poll();
			if(temp.left==null){
				temp.left=new BTreeNode(data);
				return root;
			}else{
				s.add(temp.left);
			}
			if(temp.right==null){
				temp.right=new BTreeNode(data);
				return root;
			}else{
				s.add(temp.right);
			}
		}
	}

	private static void inOrderUtil(BTreeNode node){
		if(node==null)return;
		inOrderUtil(node.left);
		System.out.println(node.data);
		inOrderUtil(node.right);
	}

	public static void inorder(BTreeNode root){
		inOrderUtil(root);
	}
	public static int maximumElement(BTreeNode root){
		if(root==null)return Integer.MIN_VALUE;
		return Math.max(root.data,Math.max(maximumElement(root.left), maximumElement(root.right)));
		
		
	}
	public static void main(String[] args) {
		BTreeNode root=null;
		root=insert(root, 1);
		root=insert(root, 2);
		root=insert(root, 3);
//		root=insert(root, 4);
//		root=insert(root, 5);
//		root=insert(root, 7);
//		root=insert(root, 6);
//		root=insert(root, 100);
		System.out.println(maximumElement(root));
		System.out.println(search(root,80));
		System.out.println(sizeOfTree(root));
		levelOrderInReverse(root);
		System.out.println("depth is "+ (depth(root)));
		minimumDepth(root);
		System.out.println("minimum depth count is " + (minimumDepthCount));
		diameter(root);
		System.out.println("Diameter is "+maxDiameter);
		maximumSum(root);
		System.out.println("Maximum sum in binary tree "+ maximumSum);
		rootToLeaf(root);
		System.out.println(sumNumbers(root));
		
	}
	public static int sumNumbers(BTreeNode root) {
		List<Integer> l=new ArrayList<>();
		String path="";
		checkSumRootToNode(root,l,path);
		int sum=0;
		for(int x:l){
			sum=sum+x;
		}
		return sum;
    }
	private static void checkSumRootToNode(BTreeNode root,List<Integer> l, String path) {
		if(root==null){
			return ;
		}
		if(root.left==null && root.right==null){
			path=path+root.data;
			int temp=Integer.parseInt(path);
			l.add(temp);
		}
		path=path+root.data;
		checkSumRootToNode(root.left,l,path);
		checkSumRootToNode(root.right,l,path);
	}

	private static void rootToLeaf(BTreeNode root) {
		String path="";
		rootToLeafUtil(root,path);
	}
	private static void rootToLeafUtil(BTreeNode root, String path) {
		if(root==null)return;
		if(root.left==null && root.right==null){
			path=path+root.data;
			System.out.println(path);
			return;
		}
		path=path+root.data+"->";
		rootToLeafUtil(root.left,path);
		rootToLeafUtil(root.right,path);
	}
	static int maximumSum=Integer.MIN_VALUE;
	private static int maximumSum(BTreeNode root) {
		if(root==null)return 0;
		int left=maximumSum(root.left);
		int right=maximumSum(root.right);
		int maxi= Math.max(left+root.data,right+root.data);
		int maxCurrent=Math.max(root.data, Math.max(left+right+root.data,maxi));
		maximumSum=Math.max(maximumSum, maxCurrent);
		return maxi;
	}

	static int maxDiameter=0;
	private static int diameter(BTreeNode root) {
		if(root==null)return 0;
		int left=diameter(root.left);
		int right=diameter(root.right);
		maxDiameter=Math.max(maxDiameter, left+right);
		return 1+Math.max(left, right);
	}
	
	static int minimumDepthCount=Integer.MAX_VALUE;
	
	private static void minimumDepthUtil(BTreeNode node,int count){
		if(node==null){
			minimumDepthCount=Math.min(minimumDepthCount, count);
			return;
		}
		count++;
		minimumDepthUtil(node.left,count);
		minimumDepthUtil(node.right,count);
	}
	private static void minimumDepth(BTreeNode root) {
		int count=0;
		minimumDepthUtil(root,count);
		
	}

	private static int depth(BTreeNode root) {
		if(root==null)return 0;
		
		return 1+Math.max(depth(root.left), depth(root.right));
	}

	private static void levelOrderInReverse(BTreeNode root) {
		if(root==null)return;
		Queue<BTreeNode> nodes=new LinkedList<>();
		Stack<Integer> printNodes=new Stack<>();
		nodes.add(root);
		while(!nodes.isEmpty()){

			BTreeNode temp=nodes.poll();
			printNodes.push(temp.data);
			if(temp.right!=null){
				nodes.add(temp.right);
			}
			if(temp.left!=null){
				nodes.add(temp.left);
			}
		}
		while(!printNodes.isEmpty()){
			int temp=printNodes.pop();
			System.out.println(temp);
		}
	}

	private static int sizeOfTree(BTreeNode root) {
		if(root==null)return 0;
		
		return 1+sizeOfTree(root.left)+sizeOfTree(root.right);
		
	}

	private static boolean search(BTreeNode root,int data) {
		if(root==null)return false;
		return root.data==data || search(root.left,data) || search(root.right,data);
	}

}
