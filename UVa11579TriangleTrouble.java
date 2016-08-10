import java.util.Arrays;
import java.util.Scanner;

public class UVa11579TriangleTrouble {

	private static Scanner in;
	private static double findArea(double a, double b, double c){
		if(a+b<c || b+c<a || c+a<b) return 0;
	    double s=(a+b+c)/2;
	    double area=Math.sqrt(s*(s-a)*(s-b)*(s-c));
	    return area;
	}
	private static double max(double a,double b){
		return a>b?a:b;
	}

	public static void main(String[] args) {
		in = new Scanner(System.in);
		int t=in.nextInt();
		while((t--)>0){
			int n=in.nextInt();
			double a[] = new double[n];
			for(int i=0;i<n;i++) a[i]=in.nextDouble();
			Arrays.sort(a);
			double area=0.0;
			for(int i=n-1;i>1;i--){
	            area=max(area,findArea(a[i],a[i-1],a[i-2]));
			}
			System.out.printf("%.2f",area);
			System.out.println();
			
			
		}
		

	}

}
