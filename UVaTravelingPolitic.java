import java.util.Scanner;
	
public class UVaTravelingPolitic {
	private static Scanner in;
	public static void main(String[] args) {
		in = new Scanner(System.in);
	    while(true){
	    	
	    	int n = in.nextInt();
	    	int m = in.nextInt();
	    	int k = in.nextInt();
	    	if (n==0 && m==0 && k==0) break;
	    	boolean a[][] = new boolean[n][20];
	    	boolean adj[][] = new boolean[n][n];
	    	for(int i=0;i<m;i++){
	    		int from= in.nextInt();
	    		int to= in.nextInt();
	    		adj[from][to]=true;
	    	}
	    	for (int i=0;i<n;i++){
	    	if(adj[0][i]) a[i][0]=true;	
	    	//System.out.println(a[i][0]);
	    	}
	    	for(int j=1;j<20;j++){
	    		for (int i=0;i<n;i++){
	    			if (a[i][j-1]){
	    			//	System.out.println(">"+i);
	    				for(int p=0;p<n;p++){
	    					if (adj[i][p]) a[p][j]=true;
	    				//	System.out.println("***"+p);
	    			}
	    			}
	    		}
	    	}
	    	int ans=-1;
	    	for(int i=k-2;i<20 && ans==-1;i++){
	    		if (a[n-1][i]==true) ans=i+2;
	    	}
	    	
	    	if (ans==-1) System.out.println("LOSER");
	    	else System.out.println(ans);
	    	
	    	/*for(int i=0 ; i<n;i++){
	    		for (int j=0;j<10;j++){
	    			System.out.print(a[i][j]+" ");
	    		}System.out.println();
	    	}*/
	    	
	    }
	    
		
	    

	}

}
