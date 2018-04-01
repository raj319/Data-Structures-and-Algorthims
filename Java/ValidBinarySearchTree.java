class Tree{
	int data;
	Tree left;
	Tree right;
	Tree(int data){
		this.data=data;
		left=null;
		right=null;
	}
}
public class ValidBinarySearchTree {
	static Tree root;
	ValidBinarySearchTree(){
		root=null;
	}
	static Tree BSTinsert(Tree node,int data){
		if(node==null){
			return new Tree(data);
		}
		if(node.data>data)
			node.left=BSTinsert(node.left,data);
		else{
			node.right=BSTinsert(node.right,data);
		}
		return node;
	}
	static void print(Tree node){
		if(node==null)return;
		print(node.left);
		System.out.println(node.data);
		print(node.right);
	}
	static boolean checkValidBST(Tree node,Tree prev){
		
		if(node==null)return true;
		if(!checkValidBST(node.left,prev))return false;
		if(prev!=null && prev.data>=node.data)return false;
		prev=node;
		return checkValidBST(node.right,prev);
	}
	
	public static void main(String[] args) {
		root=BSTinsert(root,6);
		root=BSTinsert(root,4);
		root=BSTinsert(root,5);
		root=BSTinsert(root,3);
		root=BSTinsert(root,8);
		root=BSTinsert(root,7);
		root=BSTinsert(root,9);
		print(root);
		if(checkValidBST(root,null)){
			System.out.println("true");
		}else{
			System.out.println("false");
		}
	}
}
