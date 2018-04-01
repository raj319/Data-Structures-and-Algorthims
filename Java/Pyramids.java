
public class Pyramids {

	public static void main(String[] args) {
		int n=3;
		int start=2*n/2;
		int end=n/2;
		StringBuffer sb=new StringBuffer();
		sb.append("'");
		for(int i=0;i<(2*n-1);i++){
			sb.append(" ");
		}
		for(int i=1;i<=n;i++){
			
			sb.setCharAt(start,'#');
			sb.setCharAt(end,'#');
			start--;
			end++;
			if(i==1)
			sb.append("'");
			System.out.println(sb.toString());
		}
	}

}
