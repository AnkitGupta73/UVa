import java.util.Scanner;

public class UVa10819Troubleof13Dots {
		private static Scanner in;
		private static int max(int a,int b){
			if (a<b) return b;
			return a;
		}
		
		public static void main(String[] args) {
			in = new Scanner(System.in);
			int capacity = in.nextInt();
			int avil = in.nextInt(); 
			capacity = capacity+200;
			
			int wt[] = new int[avil];
			int value[] = new int[avil];
			
			int dynamic[][] = new int[capacity+1][avil];
			
			int i,j;
			for (i=0;i<avil; i++ ) { 
				wt[i]=in.nextInt();
				value[i]=in.nextInt();
			}
			
			for (i=0;i<=capacity;i++){
				if (i >=wt[0]) dynamic[i][0]=value[0];
			}
			
			
			for (j=1;j<avil;j++){
				for (i=1;i<=capacity;i++){
					if (i-wt[j]>=0)
					dynamic[i][j] = max(dynamic[i][j-1],value[j]+dynamic[i-wt[j]][j-1]);
					else dynamic[i][j] = dynamic[i][j-1];
				}
			}
			//System.out.println(dynamic[capacity][avil-1]);
			int ans=-1;
			for(i=0;i<capacity-200;i++) ans=max(ans,dynamic[i][avil-1]);
			for(i=2001;i<capacity;i++) ans=max(ans,dynamic[i][avil-1]);
			System.out.println(ans);
		}

	}
