import java.util.Scanner;

public class UVa143OrchardTrees {

	private static Scanner in;
	private static double area(double x1, double y1, double x2, double y2, double x3, double y3)
	{
	   double area= ((x1*(y2-y3) + x2*(y3-y1)+ x3*(y1-y2))/2.0);
	   if (area<0) return -area;
	   return area;
	}
	 
	
	private static boolean isInside(double x1, double y1, double x2, double y2, double x3, double y3, double x, double y)
	{   
	
	   double A = area (x1, y1, x2, y2, x3, y3);
	   double A1 = area (x, y, x2, y2, x3, y3);
	   double A2 = area (x1, y1, x, y, x3, y3);
	   double A3 = area (x1, y1, x2, y2, x, y);
	   return (A1+A2+A3 <= A + 1e-7)? true: false;
	}
	public static void main(String[] args) {
		in = new Scanner(System.in);
		 double x1,y1,x2,y2,x3,y3;
		
		 while(true){
			 int count=0;
			 x1= in.nextDouble();
			 y1=in.nextDouble();
			 x2=in.nextDouble();
			 y2=in.nextDouble();
			 x3=in.nextDouble();
			 y3=in.nextDouble();
			 if(x1==0 && y1==0 && x2==0 && y2==0 && x3==0 && y3==0) break;
			 for(int i=1;i<100;i++){
				 for(int j=1;j<100;j++){
					 if (isInside(x1,y1,x2,y2,x3,y3,i,j)) count++; 
				 }
			 }
			 System.out.println(count);
		 }
		

	}

}
