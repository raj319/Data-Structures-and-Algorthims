
public class CapitalizeFirstLetter {

	public static void main(String[] args) {
		String name="look, it is working!";
		if(name.length()==0){
			System.out.println(name);
			return;
		}
		StringBuffer sb=new StringBuffer();
		sb.append((char)(name.charAt(0)-32));
		for(int i=1;i<name.length();i++){
			if(name.charAt(i-1)==' ' && (name.charAt(i)>='a' && name.charAt(i)<='z')){
				sb.append((char)(name.charAt(i)-32));
				continue;
			}
			sb.append(name.charAt(i));
		}
		System.out.println(sb.toString());
	}

}
