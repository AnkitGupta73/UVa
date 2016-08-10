import java.util.Scanner;

public class UVa11450WeddingShopping {
	private static Scanner in;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		in = new Scanner(System.in);
		int testCase = in.nextInt();
		while((testCase--)>0){
			int amount =in.nextInt();
			int options = in.nextInt();
			boolean dp[][]=new boolean[options][201];
			
			int n=in.nextInt();
			while((n--)>0){
				int cost=in.nextInt();
				dp[0][cost]=true;
			}
			
			for(int i=1;i<options;i++){
				n=in.nextInt();
				while((n--)>0){
					int cost=in.nextInt();
					for (int j=0;j<200;j++){
						if(dp[i-1][j]==true && j+cost<201){
							dp[i][j+cost]=true;
						}
					}
				}
			}
			int ans=-1;
			for(int i=amount;i>=0;i--){
				if(dp[options-1][i]==true){
					ans=i;
					i=-1;
				}
			}
			if(ans==-1) System.out.println("no solution");
			else System.out.println(ans);
		}
	}

}
