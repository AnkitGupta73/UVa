import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;


public class UVa10394TwinPrimess {
	private static Scanner in;
	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

	//	in = new Scanner(System.in);
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = 20000010;
		boolean prime[] = new boolean[N+1];
		int pairs[][] = new int[200000][2];
		
		//System.out.println(prime[12]);
		Arrays.fill(prime,true);
		prime[0]=false;
		prime[1]=false;
		
		for (int p = 2; p * p <= N; ++p){
			if (prime[p]){
				for (int i = p * p; i <= N; i += p){
					prime[i] = false;
				}
			}
		}
		int count=0;
		for (int i = 0; i < N - 2; i++){
			if (prime[i] && prime[i + 2]){
				pairs[count][0]= i;
				pairs[count][1]=i+2;
				count++;
						
				
			}
		}
		
		String line;
	     	int tt=5;
		while ((line = in.readLine()) != null) {
			int tmp = Integer.parseInt(line);
			System.out.println("("+pairs[tmp-1][0]+", "+pairs[tmp-1][1]+")");
		
		}
	}

}