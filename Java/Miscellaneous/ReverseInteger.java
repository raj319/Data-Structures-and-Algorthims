
public class ReverseInteger {

	public static void main(String[] args) {
		int num=-1234;
		boolean isNegative=false;
		if(num<0){
			isNegative=true;
			num=num*-1;
		}
		int res=0;
		while(num>0){
			res=res*10+(num%10);
			num=num/10;
		}
		if(isNegative)
			System.out.println(res*-1);
		else
			System.out.println(res);
	}

}
