
public class ConsecutiveSum {
	static int countConsecutive(int num){
		int count=0;
		
        long i=1;
        long j=i+1;
        long sum=i+j;
        while(j<=(num/2)+1){
        	System.out.println(sum);
            if(sum<num){
                j++;
                sum=sum+j;
            }else if(sum==num){
                count++;
                sum=sum-i;
                i++;
            }else{
                sum=sum-i;
                i++;
            }
         }
		return count;
	}
	public static void main(String[] args) {
		int N = 15;
        System.out.println(countConsecutive(N));
	}

}
