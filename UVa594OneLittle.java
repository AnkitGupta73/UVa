import java.util.Scanner;


public class UVa594OneLittle {

	/**
	 * @param args
	 */
	private static Scanner in;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		in = new Scanner(System.in);
		while(in.hasNext()){
			int n = in.nextInt();
			int ans = Integer.reverseBytes(n);
			System.out.println(n+" converts to "+ans);
			
		}
	}

}
