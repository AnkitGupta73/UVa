import java.util.Scanner;

public class UVa11790MurciasSkyline {
	private static Scanner in;
	
	private static int max(int a,int b){
		return a>b?a:b;
	}
	
	private static int lis(int n,int height[],int weight[]){
		int dp[] = new int[n];
		for(int i=0;i<n;i++){
			dp[i]=weight[i];
			for(int j=0;j<i;j++){
				if(height[j]<height[i]){
					dp[i]=max(dp[i],weight[i]+dp[j]);
				}
			}
		}
		int max=-1;
		for(int i=0;i<n;i++){
			max = max(max,dp[i]);
		}
		return max;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		in = new Scanner(System.in);
		int testCase = in.nextInt();
		int caseNumber=1;
		while((testCase--)>0){
			System.out.print("Case "+(caseNumber++)+". ");
			int n = in.nextInt();
			int[] height = new int[n];
			int[] weight = new int[n];
			for(int i=0;i<n;i++) height[i]=in.nextInt();
			for(int i=0;i<n;i++) weight[i]=in.nextInt();
			int increasing =lis(n,height,weight);
			int[] heightReverse = new int[n];
			int[] weightReverse = new int[n];
			
			for(int i=0;i<n;i++){
				heightReverse[i]=height[n-i-1];
				weightReverse[i]=weight[n-i-1];
			}
			int decreasing = lis(n,heightReverse,weightReverse);
			if(increasing>=decreasing){
				System.out.println("Increasing ("+increasing+"). Decreasing ("+decreasing+").");
			}
			else System.out.println("Decreasing ("+decreasing+"). Increasing ("+increasing+").");
		}
	}

}
