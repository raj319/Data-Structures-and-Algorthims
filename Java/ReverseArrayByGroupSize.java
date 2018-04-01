
public class ReverseArrayByGroupSize {
	public static void reverse(int[] arr,int s,int e){
		while(s<e){
			int temp=arr[s];
			arr[s]=arr[e];
			arr[e]=temp;
			s++;
			e--;
		}
	}
	public static void reverseArrayByK(int[] arr,int k){
		int count=1;
		int start=0;
		int i;
		for(i=0;i<arr.length;i++){
			if(count==k){
				reverse(arr,start,i);
				start=i+1;
				count=0;
			}
			count++;
		}
		if(count>0){
			reverse(arr,start,i-1);
		}
	}
	public static void main(String[] args) {
		int[] arr=new int[]{1,2};
		int k=1;
		reverseArrayByK(arr,k);
		for(int i:arr){
			System.out.println(i);
		}
	}

}
