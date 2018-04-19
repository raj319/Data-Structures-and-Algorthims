
public class Anagrams {

	public static void main(String[] args) {
		String str1="Hi there";
		String str2="Bye there";
		
		int[] arr=new int[26];
		for(int i=0;i<str1.length();i++){
			if((str1.charAt(i)>='a' && str1.charAt(i)<='z') ){
				arr[str1.charAt(i)-97]++;
			}
			else if(str1.charAt(i)>='A' && str1.charAt(i)<='Z'){
				arr[str1.charAt(i)-65]++;
			}
		}
		for(int i=0;i<str2.length();i++){
			if((str2.charAt(i)>='a' && str2.charAt(i)<='z') ){
				arr[str2.charAt(i)-97]--;
			}
			else if(str2.charAt(i)>='A' && str2.charAt(i)<='Z'){
				arr[str2.charAt(i)-65]--;
			}
		}
		for(int i=0;i<arr.length;i++){
			if(arr[i]!=0){
				System.out.println("False");
				return;
			}
		}
		System.out.println("True");
	}

}
