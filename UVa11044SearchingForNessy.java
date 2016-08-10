import java.util.Scanner;


public class UVa11044SearchingForNessy {

	/**
	 * @param args
	 */
	private static Scanner in;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		in = new Scanner(System.in);
		int testcase = in.nextInt();
		while((testcase--)>0){
			int n = in.nextInt()-2;
			int m = in.nextInt()-2;
			int x,y;
			if(n%3==0) x=n/3;
			else x=n/3+1;
			if(m%3==0) y=m/3;
			else y=m/3+1;
			int ans = x*y;
			System.out.println(ans);
			
		}
	}

}
