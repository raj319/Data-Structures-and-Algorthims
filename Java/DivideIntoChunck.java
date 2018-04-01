import java.util.ArrayList;
import java.util.List;

public class DivideIntoChunck {

	public static void main(String[] args) {
		int[] arr=new int[]{1,2,3,4,5};
		int chunk=3;
		int count=0;
		List<List<Integer>> l=new ArrayList<List<Integer>>();
		ArrayList<Integer> a=new ArrayList<>();
		for(int i=0;i<arr.length;i++){
			count++;
			a.add(arr[i]);
			if(count==chunk){
				count=0;
				l.add(a);
				a=new ArrayList<>();
			}
		}
		if(count!=0)l.add(a);
		System.out.println(l);
	}
}
