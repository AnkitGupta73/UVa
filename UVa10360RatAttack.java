import java.util.Scanner;


public class UVa10360RatAttack {

	private static Scanner in;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		in = new Scanner(System.in);
		int tc = in.nextInt();
		while((tc--)>0){
		
			int killed[][]=new int[1024][1024];
			
			int d =in.nextInt();
			int n=in.nextInt();
			
			for(int i=0;i<n;i++){
				int x = in.nextInt();
				int y = in.nextInt();
				int rat = in.nextInt();
				for(int j=x-d;j<=x+d;j++){
					if(j<0 || j>=1024) continue;
					for(int k=y-d;k<=y+d;k++){
						if(k<0 || k>=1024) continue;
						
						killed[j][k]+=rat;
					}
					
				}
				
				
			}
			int x=0,y=0;
			int maximum = -1;
			for (int i = 0; i < 1024; i++) {
				for (int j = 0; j < 1024; j++) {
					if (killed[i][j] > maximum) {
						x = i;
						y = j;
						maximum = killed[i][j];
					}
				}
			}
			System.out.println(x+" "+y+" "+maximum);
			
			
			
		}
	}

}
