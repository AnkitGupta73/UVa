import java.util.Scanner;


public class UVa12455Bars {

	/**
	 * @param args
	 */
	private static Scanner in;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		in  = new Scanner(System.in);
		int testCase = in.nextInt();
		while((testCase--)>0){
			int n =in.nextInt();
			int p = in.nextInt();
			int l[] = new int[p];
			for(int i=0;i<p;i++) l[i]=in.nextInt();
			boolean flag=false;
			if(n==0) flag=true;
			for(int i=0;i< (1<<p);i++){
				int sum=0;
				for(int j=0;j<p;j++){
					if((i & (1 << j))!=0){
						sum += l[j];
						if(sum==n) {
							flag=true;
							break;
						}
					}
				}
				
			}
			if(flag==true) 
				System.out.println("YES");
			else 
				System.out.println("NO");
		}
	}

}
