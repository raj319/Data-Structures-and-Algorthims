
import java.util.Stack;

public class QueueUsingStack {
	static Stack<Integer> s1;
	static Stack<Integer> s2;
	QueueUsingStack(){
		s1=new Stack<>();
		s2=new Stack<>();
	}
 	void put(int data){
		s1.push(data);
	}
 	void pop(){
 		if(!s2.isEmpty()){
 			System.out.println("popped element is"+s2.pop());
 		}else{
 			while(!s1.isEmpty()){
 				s2.push(s1.pop());
 			}
 			if(!s2.isEmpty())
 			System.out.println("popped element is"+s2.pop());
 		}
 	}
	public static void main(String[] args) {
		QueueUsingStack queue=new QueueUsingStack();
		queue.put(10);
		queue.put(5);
		queue.put(6);
		queue.put(4);
		queue.put(11);
		queue.pop();
		queue.pop();
		queue.pop();
		queue.pop();
		queue.pop();
		queue.pop();
		queue.put(5);
		queue.put(6);
		queue.pop();
	}

}
