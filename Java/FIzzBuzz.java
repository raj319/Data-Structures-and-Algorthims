
public class FIzzBuzz {

	public static void main(String[] args) {
		int n=10;
		for(int i=1;i<=15;i++){
			if(i%3==0 && i%5==0){
				System.out.println("fizzbuzz");
			}
			else if(i%3==0){
				System.out.println("fizz");
			}else if(i%5==0){
				System.out.println("buzz");
			}else{
				System.out.println(i);
			}
		}
	}

}
