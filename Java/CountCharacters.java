
public class CountCharacters {
	public static void main(String args[]){
		String temp="abcea";
		int count=0;
		String result="";
		for(int i=1;i<temp.length();i++){
			
			if(temp.charAt(i-1)==temp.charAt(i)){
				count++;
				continue;
			}else{
				result=result+temp.charAt(i-1)+(++count);
				count=0;
			}
		}
		if(temp.length()>0)
		result=result+temp.charAt(temp.length()-1)+(++count);
		System.out.println(result);
	}
}
