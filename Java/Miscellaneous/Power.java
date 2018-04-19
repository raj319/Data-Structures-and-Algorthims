
public class Power {
	public static int power(int x,int n){
		if(n==1)return x;
		if(n==0)return 1;
		int temp=power(x,n/2);
		if(n%2==0){
			return temp*temp;
		}else{
			return x*temp*temp;
		}
	}
	public static void main(String[] args) {
		int x=2;
		int n=5;
		int result=power(x,n);
		System.out.println(result);
	}

}
