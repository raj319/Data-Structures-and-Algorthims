package com.rajkiran.miscellaneous;
import java.util.Stack;

public class BinaryTreeStructurallyIdentical {
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
	TreeNode root;
	BinaryTreeStructurallyIdentical(){
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
	static boolean structurallyIdentical(TreeNode node1,TreeNode node2){
		
		if(node1==null && node2==null)return true;
		if(node1==null || node2==null)return false;
		
		return node1.data==node2.data && structurallyIdentical(node1.left,node2.left) && structurallyIdentical(node1.right,node2.right);
		
	}
	public static void main(String[] args) {
		BinaryTreeStructurallyIdentical tree1=new BinaryTreeStructurallyIdentical();
		BinaryTreeStructurallyIdentical tree2=new BinaryTreeStructurallyIdentical();
		tree1.root=new TreeNode(1);
		tree1.root.left=new TreeNode(2);
		tree1.root.right=new TreeNode(3);
		tree1.root.left.left=new TreeNode(4);
		tree1.root.left.right=new TreeNode(5);
		tree1.root.right.left=new TreeNode(6);
		tree1.root.right.right=new TreeNode(1);
		tree2.root=new TreeNode(1);
		tree2.root.left=new TreeNode(2);
		tree2.root.right=new TreeNode(3);
		tree2.root.left.left=new TreeNode(4);
		tree2.root.left.right=new TreeNode(5);
		tree2.root.right.left=new TreeNode(9);
		tree2.root.right.right=new TreeNode(1);
		System.out.println(structurallyIdentical(tree1.root,tree2.root));
	}
}
