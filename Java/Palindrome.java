
public class Palindrome {

	public static void main(String[] args) {
		String name="abcba";
		char[] arr=name.toCharArray();
		int i=0;
		int j=arr.length-1;
		while(i<j){
			if(arr[i]!=arr[j]){
				System.out.println("Not a palindrome");
				return;
			}
			i++;
			j--;
		}
		System.out.println("Given string is a palindrome");
	}

}
