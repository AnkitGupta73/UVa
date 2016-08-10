import java.util.Scanner;

public class UVa10827MaximumSumOnATorus {
	
	private static int maxSubArraySum(int a[],int n){
		int maxSoFar=Integer.MIN_VALUE;
		
		
		for(int i=0;i<n;i++){
			int maxEnding=0;
			for(int j=i;j<i+n;j++){
				maxEnding +=a[j];
				if(maxSoFar<maxEnding){
					maxSoFar=maxEnding;
				}
			}
		}
		return maxSoFar;
	}
	private static Scanner in;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		in = new Scanner(System.in);
		int testCase=in.nextInt();
		//System.out.println(maxSubArraySum(a));
		while((testCase--)>0){
			int n=in.nextInt();
			int a[][] = new int[2*n][2*n];
			for(int i=0;i<n;i++){
				for(int j=0;j<n;j++){
					a[i][j]=in.nextInt();
					a[i][j+n]=a[i][j];
					a[i+n][j]=a[i][j];
					a[i+n][j+n]=a[i][j];
				}
			}
			
			int maxSum=Integer.MIN_VALUE;
			
			for(int i=0;i<n;i++){
				int c[] = new int[2*n];
				for(int j=i;j<i+n;j++){
					for(int k=0;k<2*n;k++){
						c[k]+=a[k][j];
					}
					maxSum=Math.max(maxSubArraySum(c,n), maxSum);
				}
			}
			System.out.println(maxSum);
		}
	}

}
