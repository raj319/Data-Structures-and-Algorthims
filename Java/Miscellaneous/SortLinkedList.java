import java.util.Iterator;

public class SortLinkedList {
	public static void main(String args[]){
		LLImplementation ll=new LLImplementation();
		ll.push(10);
		ll.push(5);
		ll.push(4);
		ll.push(3);
		ll.push(2);
		ll.push(1);
		insert(ll.root,6);
		print(ll.root);
		
		
//		print(ll.root);
	}
	static void insert(Node n,int d){
		Node prev=null;
		while(n!=null){
			if(n.data>d){
				break;
			}
			prev=n;
			n=n.next;
		}
		Node temp=new Node(d);
		prev.next=temp;
		temp.next=n;
	}
	static void print(Node n){
		while(n!=null){
			System.out.println(n.data);
			n=n.next;
		}
	}
}
