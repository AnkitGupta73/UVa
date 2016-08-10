import java.util.Scanner;


public class UVa679DroppingBalls {

	private static Scanner in;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		in = new Scanner(System.in);
		int TC = in.nextInt();
		while((TC--)>0){
			int depth = in.nextInt();
			int drop = in.nextInt();
			//drop %= 1<<depth;
			
			int pos=1;
			
			for(int i=1;i<depth;i++){
				pos *=2;
				
				if(drop%2==0) pos++;
				else drop++;
				
				drop /=2;
				
			}
			System.out.println(pos);
			
		}
		TC=in.nextInt();
	}

}
