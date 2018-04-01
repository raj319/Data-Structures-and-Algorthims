import java.util.HashMap;

public class FirstNonRepeatedChar {
	public static void main(String args[]){
		String temp="company1 isthebestcompanytoworkfor";
		HashMap<Character,Integer> hm=new HashMap<>();
		for(int i=0;i<temp.length();i++){
			int count=0;
			if(temp.charAt(i)==' ')continue;
			if(hm.containsKey(temp.charAt(i))){
				count=hm.get(temp.charAt(i));
			}
			hm.put(temp.charAt(i), ++count);
		}
		for(int i=0;i<temp.length();i++){
			if(temp.charAt(i)==' ')continue;
			if(hm.get(temp.charAt(i))==1){
				System.out.println(temp.charAt(i));
				break;
			}
		}
	}
}
