import java.util.Scanner;


public class UVa725Division {
	private static Scanner in;
	
	private static boolean alldiff(int a,int b){
		boolean[] v = new boolean[10];
		for(int i=0;i<5;i++){
			int t1 = a%10;
			int t2 = b%10;
			b=b/10;
			a=a/10;
			if(v[t1]) 
				return false;
			else 
				v[t1]=true;	
			if(v[t2])  
				return false;
			else 			
				v[t2]=true;
			
		}
		
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		in = new Scanner(System.in);
		int tt=0;
		while(true){
			int n = in.nextInt();
			if(n==0) break;
			if(tt!=0) System.out.println();
			tt++;
			boolean found = false;
			for(int dr = 1234 ; dr<50000;dr++){
				int nr = n*dr;
				if (nr>99999) break;
				if(alldiff(nr,dr)){
					System.out.print(nr+" / ");
					System.out.printf("%05d",dr);
					System.out.println(" = "+n);
					found =true;
				}
				
			}
			if(found==false) System.out.println("There are no solutions for "+n+".");
			
		}
	}

}
