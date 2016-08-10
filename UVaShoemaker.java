import java.util.Scanner;
public class UVaShoemaker {
	
	private static Scanner in;

	public static void main(String[] args) {
		in = new Scanner(System.in);
		int a0 = in.nextInt();
		while (a0>0){
			a0--;
			int n  = in.nextInt();
			
			int indx[]=new int[n];
			Double perday[] = new Double[n];
			for (int i=0;i<n;i++){
				Double t = in.nextDouble();
				
				Double s = in.nextDouble();

				perday[i]=(s/t);
				indx[i]=i+1;
				//System.out.println("Perday= "+perday[i]+" indx= "+indx[i]);
			}
			
			for(int i=0;i<n;i++){
       				for(int j=0;j<n-i-1;j++){
				    if(perday[j]<perday[j+1]){
					Double tmp = perday[j];
					perday[j] = perday[j+1];
					perday[j+1] = tmp;
					int temp = indx[j];
					indx[j] = indx[j+1];
					indx[j+1] = temp;
			    }
			}
		    }
			
			
			for (int i=0;i<n;i++){
			if(i!=(n-1)) System.out.print((indx[i])+" ");
			else System.out.print(indx[i]);
			}
			
			if(a0!=0) {System.out.println();
			System.out.println();
			}
			else System.out.println();
		}
		

	}

}
