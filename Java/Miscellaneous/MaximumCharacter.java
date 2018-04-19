import java.util.HashMap;

public class MaximumCharacter {

	public static void main(String[] args) {
		String name="abca";
		HashMap<Character,Integer> hm=new HashMap<>();
		int count;
		int max=0;
		char maxi=' ';
		for(int i=0;i<name.length();i++){
			count=0;
			if(hm.containsKey(name.charAt(i))){
				count=hm.get(name.charAt(i));
			}
			count++;
			if(max<count){
				max=count;
				maxi=name.charAt(i);
			}
			hm.put(name.charAt(i), count);
		}
		System.out.println("Maximum frequency: "+max);
		System.out.println("Maximum frequency character: "+maxi);
	}

}
