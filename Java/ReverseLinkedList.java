class LinkedList1{
	int data;
	LinkedList1 next;
	LinkedList1(int data){
		this.data=data;
		next=null;
	}
}
public class ReverseLinkedList {
	static LinkedList1 root;
	ReverseLinkedList(){
		root=null;
	}
	static LinkedList1 insert(LinkedList1 node,int data){
		LinkedList1 temp=new LinkedList1(data);
		temp.next=node;
		node=temp;
		return node;
	}
	static void print(LinkedList1 node){
		while(node!=null){
			System.out.println(node.data);
			node=node.next;
		}
	}
	static LinkedList1 reverse(LinkedList1 node){
		LinkedList1 curr=null;
		LinkedList1 temp=null;
		while(node!=null){

			temp=node.next;
			node.next=curr;
			curr=node;
			node=temp;
		}
		return curr;
	}
	public static void main(String[] args) {
		root=insert(root,10);
		root=insert(root,9);
		root=insert(root,8);
		root=insert(root,7);
		root=insert(root,6);
		root=insert(root,5);
		print(root);
		root=reverse(root);
		print(root);
	}

}
