import java.util.Scanner;

public class UVa11151LongestPalindrome {
	private static Scanner in;
	private static int max(int a,int b){
		return a>b?a:b;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		in = new Scanner(System.in);
		int testCase = in.nextInt();
		String s = in.nextLine();
		while((testCase--)>0){
			 s = in.nextLine();
			int l = s.length();
			if(l>0){
				
			
				char c[] = s.toCharArray();
				int dp[][] = new int[l][l];
				for(int i=0;i<l;i++) dp[i][i]=1;
				
				for(int k=1;k<l;k++){
					for(int i=0,j=k;i<l && j<l;i++,j++){
						if(c[i]==c[j]){
							dp[i][j] = dp[i+1][j-1]+2;
						}
						else dp[i][j] = max(dp[i][j-1],dp[i+1][j]);
					}
				}
				/*
				for(int i=0;i<l;i++){
					for(int j=0;j<l;j++){
						System.out.print(dp[i][j]+" ");
					}
					System.out.println();
				}
				System.out.println();
				*/
				System.out.println(dp[0][l-1]); 
			}
			else System.out.println("0");
			
		}
	}

}
