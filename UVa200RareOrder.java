import java.util.Scanner;

public class UVa200RareOrder {

	private static Scanner in;

	public static void main(String[] args) {
		in = new Scanner(System.in);
		int a[][] = new int[5000][21];
		int L[] = new int[26];
		int i=0;
		int j,n;
		while(true){
			String s = in.next();
			if(s.charAt(0)=='#') break;
			int l =s.length();
			
			for(j=0;i<l;i++){
				a[i][j]= s.charAt(j);
			}
			while (j != 21) a[i][j++] = 'a'; 
			i++;
	     }
		for(int t1=0;t1<i;t1++){
			for(int t2=0;t2<21;t2++){
				System.out.print(a[t1][t2]+" ");
			}
			System.out.println();
		}
		for (j = 0; j < 21; j++)
	    {
	        for (n = 0; n < i; n++)
	        	System.out.print("* "+a[n][j]);
	       {    if (a [n] [j] > 64 && a [n] [j] < 91)
	                L [(a[n][j]-65)]++;
	            if (L [( a[n][j]-65)] == 1)
	                System.out.print(a[n][j]+" ");
	        }
	    }
			
		}

	}


