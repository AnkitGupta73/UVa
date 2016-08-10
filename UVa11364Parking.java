import java.util.Scanner;


public class UVa11364Parking {

	/**
	 * @param args
	 */
	private static Scanner in;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		in = new Scanner(System.in);
		int testCase = in.nextInt();
		while((testCase--)>0){
			int n= in.nextInt();
			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;
			for(int i=0;i<n;i++){
				int tmp = in.nextInt();
				min = Math.min(tmp, min);
				max = Math.max(tmp, max);
			}
			int ans = 2*(max-min);
			System.out.println(ans);
		}
	}

}
