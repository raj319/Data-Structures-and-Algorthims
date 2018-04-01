
public class ReverseString {

	public static void main(String[] args) {
		String name="Greetings!";
		char[] arr=name.toCharArray();
		int i=0;
		int j=arr.length-1;
		char temp;
		while(i<j){
			temp=arr[i];
			arr[i]=arr[j];
			arr[j]=temp;
			i++;
			j--;
		}
		for(char k:arr)
		System.out.print(k);
	}
}
