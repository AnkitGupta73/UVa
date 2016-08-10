import java.util.Scanner;

public class UVa10003CuttingSticks {
	private static Scanner in;
	private static int min(int a,int b){
		return a>b?b:a;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		in = new Scanner(System.in);
		while(true){
			int rodL = in.nextInt();
			if(rodL==0) break;
			int cuts = in.nextInt();
			int coord[] = new int[cuts+2];
			coord[0]=0;
			coord[cuts+1]=rodL;
			for(int i=1;i<=cuts;i++) coord[i] = in.nextInt();
			//int cost=Integer.MAX_VALUE;
			
			int DP[][] = new int[52][52];
			int i, j, k, L;
			
			for(L = 2; L <= cuts+1; L++){
		        for(i = 0; i <= (cuts+1 - L); i++){
		            j = i + L;
		            DP[i][j] = Integer.MAX_VALUE;
		            for(k = i+1; k < j; k++){
		                DP[i][j] = min(DP[i][j], DP[i][k] + DP[k][j] + (coord[j] - coord[i]));
		            }
		        }
		    }
			System.out.println("The minimum cutting is "+DP[0][cuts+1]+".");
			
			
			
			
		}
	}

}
