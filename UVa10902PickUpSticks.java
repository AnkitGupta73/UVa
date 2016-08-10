import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.Scanner;

public class UVa10902PickUpSticks {
	private static Scanner in; 
	private static boolean overlap(double a[][],int l,int m){
		Point2D.Double temp1 = new Point2D.Double(a[0][l], a[1][l]);
       
        Point2D.Double temp2 = new Point2D.Double(a[2][l], a[3][l]);
       
        Point2D.Double temp3 = new Point2D.Double(a[0][m], a[1][m]);
       
        Point2D.Double temp4 = new Point2D.Double(a[2][m], a[3][m]);

       
        boolean intersects = Line2D.linesIntersect(temp1.x, temp1.y, temp2.x, temp2.y, temp3.x, temp3.y, temp4.x, temp4.y);

        //determines if the lines share an endpoint
        boolean shareAnyPoint = shareAnyPoint(temp1, temp2, temp3, temp4);
		
        if (intersects && shareAnyPoint) {
            return false;
        } else if (intersects && !shareAnyPoint) {
           return true;
        } 
        return false;
		
	//	Line2D line1 = new Line2D.Double(a[0][l], a[1][l], a[2][l], a[3][l]);
		//Line2D line2 = new Line2D.Double(a[0][m], a[1][m], a[2][m], a[3][m]);
		//return line2.intersectsLine(line1);
	}
	public static boolean shareAnyPoint(Point2D.Double A, Point2D.Double B, Point2D.Double C, Point2D.Double D) {
	    if (isPointOnTheLine(A, B, C)) return true;
	    else if (isPointOnTheLine(A, B, D)) return true;
	    else if (isPointOnTheLine(C, D, A)) return true;
	    else if (isPointOnTheLine(C, D, B)) return true;
	    else return false;
	}
	public static boolean isPointOnTheLine(Point2D.Double A, Point2D.Double B, Point2D.Double P) {  
	    double m = (B.y - A.y) / (B.x - A.x);

	    //handle special case where the line is vertical
	    if (Double.isInfinite(m)) {
	        if(A.x == P.x) return true;
	        else return false;
	    }

	    if ((P.y - A.y) == m * (P.x - A.x)) return true;
	    else return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		in = new Scanner(System.in);
		int t0 = 0;
		while(true){
			int n = in.nextInt();
			if (n==0) break;
			if(t0==1) System.out.println();
			double a[][] = new double[4][n];
			int ans[] = new int[1000];
			for(int i=0;i<n;i++){
				for(int j=0;j<4;j++){
					a[j][i] = in.nextDouble();
				}
			}
			ans[0]=n;
			int end=1;
			for(int i=n-2;i>=0;i--){
				int flag=0;
				for(int j=0;j<end;j++){
					if(overlap(a,i,(ans[j]-1))) flag=1;
				}
				if(flag==0){
					ans[end++]=i+1;
				}
				
			}
			System.out.print("Top sticks: ");
			for(int i=end-1;i>=0;i--) {
				System.out.print(ans[i]);
				if(i>0)System.out.print(", ");
				else System.out.print(".");
			}
			t0=1;
		}
	}

}
