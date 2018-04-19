
class Node{
	int data;
	Node next;
	Node(int data){
		this.data=data;
		next=null;
	}
}
public class LLImplementation {
	Node root;
	LLImplementation(){
		root=null;
	}
	void push(int data){
		Node temp=new Node(data);
		System.out.println(data);
		temp.next=root;
		root=temp;
	}
	
}
