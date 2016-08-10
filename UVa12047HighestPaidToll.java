import java.util.Arrays;
import java.util.Scanner;

public class UVa12047HighestPaidToll {
	private static Scanner in;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		in = new Scanner(System.in);
		int testCase = in.nextInt();
		while((testCase--)>0){
			int n = in.nextInt();
			int m = in.nextInt();
			int s = in.nextInt();
		//	int t = in.nextInt();
			int p = in.nextInt();
			int dp[][] = new int[n+1][m+1];
			Arrays.fill(dp, -1);
			
			int graph[][] = new int[n+1][n+1];
			boolean gp[][] = new boolean[n+1][n+1];
			for(int i=0;i<m;i++){
				int u = in.nextInt();
				int v = in.nextInt();
				int c = in.nextInt();
				graph[u][v] = c;
				gp[u][v] = true;
			}
			for(int i=0;i<n+1;i++){
				if(gp[s][i]==true && graph[s][i]<=p){
					dp[0][i] = graph[s][i];
				}
			}
			
			for(int i=1;i<m+1;i++){
				for(int j=0;j<n+1;j++){
					if(dp[i-1][j]>0){
						
					}
				}
			}
		}
	}

}
