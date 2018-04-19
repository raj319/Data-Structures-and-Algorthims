import java.util.LinkedList;
import java.util.Queue;

public class Weave {
	static Queue<Integer> combine(Queue<Integer> q1,Queue<Integer> q2){
		Queue<Integer> q3=new LinkedList<>();
		int count=0;
		while(!q1.isEmpty() && !q2.isEmpty()){
			if(count==0){
				q3.add(q1.poll());
				count=1;
			}else{
				q3.add(q2.poll());
				count=0;
			}
		}
		while(!q1.isEmpty()){
			q3.add(q1.poll());
		}
		while(!q2.isEmpty()){
			q3.add(q2.poll());
		}
		return q3;
	}
	public static void main(String[] args) {
		Queue<Integer> q1 = new LinkedList<>() ;
		q1.add(1);
		q1.add(3);
		q1.add(5);
		q1.add(7);
		Queue<Integer> q2 = new LinkedList<>() ;
		q2.add(2);
		q2.add(4);
		Queue<Integer> q3=combine(q1,q2);
		for(Integer i:q3){
			System.out.println(i);
		}
	}

}
