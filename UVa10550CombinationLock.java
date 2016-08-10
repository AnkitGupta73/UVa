import java.util.Scanner;


public class UVa10550CombinationLock {

	/**
	 * @param args
	 */
	private static Scanner in;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		in = new Scanner(System.in);
		
		while (true){
			//int count=0;
			int init = in.nextInt();
			int c1=in.nextInt();
			int c2=in.nextInt();
			int c3=in.nextInt();
			if(init==0 && c1==0 && c2==0 && c3==0) break;
			
			int ans = 1080;
			ans += (init - c1) > 0 ? (init - c1) * 9 : (init - c1 + 40) * 9;
			ans += (c2 - c1) > 0 ? (c2 - c1) * 9 : (c2 - c1 + 40) * 9;
			ans += (c2 - c3) > 0 ? (c2 - c3) * 9 : (c2 - c3 + 40) * 9;
			System.out.println(ans);
			
		}
		
		

	}

}
