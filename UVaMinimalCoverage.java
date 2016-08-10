import java.util.Scanner;
public class UVaMinimalCoverage {
	private static Scanner in;
	
	static int min(int a,int b){
		return  a>b?b:a ;
	}
	static int max(int a,int b){
		return a>b?a:b;
	}
	public static void main(String[] args) {
		
		in = new Scanner(System.in);
		int test = in.nextInt();
		for (int a0=0;a0<test;a0++){
			//String s= in.next();
			//l = new LinkedList();
			int M = in.nextInt();
			int L[] = new int[M+1];
			int R[] = new int[M+1];
			int m[] = new int[M+1];
			boolean mb[] = new boolean[M+1];
			for (int i=0;i<=M;i++){
				mb[i]=false;
			}
			int count=0;
			while (true){
				int l = in.nextInt();
				int r = in.nextInt();
				if (l==0 && r==0) break;
				int li = max(l,0);
				int ri = min(M,r);
				
				for (int j=li;j<=ri;j++){
					if(m[j]<r) {
						m[j]=ri;
						L[j]=l;
						R[j]=r;
						mb[j]=true;
				
					}
				}
				
				
				
			}
			for (int i=0;i<=M;i++){
				System.out.println("L "+L[i]+" R "+R[i]);
			}
			int a=0;
			int flag =0 ;
			for (int i=0;i<M;i++){
				if(mb[i]==false) flag=1;
				if (R[i]!=a){
					count++;
					a=R[i];
				}
				
				
				
			}
			if (flag==1) System.out.println("0");
			else {
				
				System.out.println(count);
				for(int i=0;i<M;i++){
					if (a!=L[i]) {
						System.out.println(L[i]+" "+R[i]);
						a = L[i];
					}
				}
			}
			System.out.println();	
		}
		

	}

}
