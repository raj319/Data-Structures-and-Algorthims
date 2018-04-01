
public class Steps {

	public static void main(String[] args) {
		int n=5;
		StringBuffer sb=new StringBuffer();
		sb.append("'");
		for(int i=0;i<n;i++){
			sb.append(" ");
		}
		sb.append("'");
		for(int i=1;i<=n;i++){
			sb.setCharAt(i, '#');
			System.out.println(sb.toString());
		}
		
		
	}

}
