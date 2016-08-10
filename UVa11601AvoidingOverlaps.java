import java.util.Scanner;

public class UVa11601AvoidingOverlaps {
	private static Scanner in;
	private static boolean check(boolean a[][],int x1,int x2,int y1,int y2){
		for(int i=x1+1;i<=x2;i++){
			for(int j=y1+1;j<=y2;j++){
				if(a[i][j]==true) return false;
			}
			
		}
		return true;
	}
	public static void main(String[] args) {
		in = new Scanner(System.in);
		int t = in.nextInt();
		int cse=1;
		while((t--)>0){
			int n= in.nextInt();
			boolean x[][] = new boolean[205][205];
			int area=0;
			while((n--)>0){
				int x1=100+in.nextInt();
				int y1=100+in.nextInt();
				int x2=100+in.nextInt();
				int y2=100+in.nextInt();
				if(check(x,x1,x2,y1,y2)){
					//System.out.println("x1= "+x1+" x2= "+x2+" y1= "+y1+" y2= "+y2);
					for(int i=x1+1;i<=x2;i++) {
						for(int j=y1+1;j<=y2;j++){
							x[i][j]=true;
						}
					}
					area +=(x2-x1)*(y2-y1);
				}
			}
			
			System.out.println("Case "+cse+": "+area);
			//else System.out.print("case "+cse+": "+area);
			cse++;
		}

	}

}
