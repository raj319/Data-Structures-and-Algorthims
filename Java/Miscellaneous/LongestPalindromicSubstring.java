
public class LongestPalindromicSubstring {
	public static String findLongestPalindrome(String s){
		int maxLength=0;
		int startIndex=0;
		boolean[][] dp=new boolean[s.length()][s.length()];
		if(s.length()==0)return s;
		for(int i=0;i<s.length();i++){
			for(int j=0;j<s.length();j++){
				dp[i][j]=false;
				
			}
		}
		for(int i=0;i<s.length();i++){
			dp[i][i]=true;
			maxLength=1;
			startIndex=i;
		}
		for(int i=0;i<s.length()-1;i++){
			if(s.charAt(i)==s.charAt(i+1)){
				dp[i][i+1]=true;
				maxLength=2;
				startIndex=i;
			}
		}
		for(int i=3;i<s.length()+1;i++){
			int k=0;
			for(int j=0;j<s.length()-i+1;j++){
				k=j+i-1;
				if(s.charAt(j)==s.charAt(k) && dp[j+1][k-1]==true){
					if(i>maxLength){
						maxLength=i;
						startIndex=j;
					}
					dp[j][k]=true;
				}
			}
		}
		return s.substring(startIndex,startIndex+maxLength );
	}
	public static void main(String[] args) {
		String s="abcdeabaedd";
		System.out.println(findLongestPalindrome(s));
	}

}
