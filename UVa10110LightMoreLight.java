import java.util.Scanner;


public class UVa10110LightMoreLight {

	/**
	 * @param args
	 * 
	 * . Perfect squares have an odd number of factors. 
	 * For example, 
	 * 4 has factors 1 2 and 4 (odd). 
	 * 12 has factors 1 2 3 4 6 12 (even). 
	 * Therefore if n is a perfect square, 
	 * output “yes”. Otherwise output “no”.
	 */
	private static Scanner in;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		in = new Scanner(System.in);
		while(true){
			int n = in.nextInt();
			if(n==0) break;
			/*boolean ans=false;
			
			for(long i=1;i<=n;i++) {
				if(n%i==0) ans=!ans;
			}
			if(ans) System.out.println("yes");
			else System.out.println("no");*/
			int root = (int) Math.sqrt(n);
			
			if(root*root == n)System.out.println("yes");
			else System.out.println("no");
				
			
			
		}
	}

}
