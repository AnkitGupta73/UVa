import java.util.Arrays;
import java.util.Scanner;

public class UVa815Flooded {
	private static Scanner in;
	
	public static double FindHeight(double lHeight,double sHeight ,double[] heights,int n,int Volume)
	{
		lHeight=100000;
	    double mHeight = 0;
	    double volumeUsed=0;
	    
	    while (Math.abs(volumeUsed - Volume) > .001)
	    {
	    	mHeight = (lHeight + sHeight) / 2;
	    	volumeUsed = VolumeUsed(mHeight, heights,n);
	        if (volumeUsed < Volume)
	            sHeight = mHeight;
	        else
	            lHeight = mHeight;
	    }
	   
	    return mHeight;
	}
	public static double VolumeUsed(double wantedHeight,double heights[],int n)
	{
	    double volume = 0;
	    for (int i = 0; i < n; i++)
	    {
	        double diff = wantedHeight - heights[i];
	        if (diff > 0)
	            volume += diff;
	    }
	    
	    return volume *= 100;
	}
	private static double getPercent(double h,double a[],int n){
		double count=0;
		for(int i=0;i<n;i++){
			if(h>a[i]) count++;
		}
		return ((count/n)*100);
	}
	
	public static void main(String[] args) {
		in = new Scanner(System.in);
		int testcase=in.nextInt();
		while((testcase--)>0){
		int n=in.nextInt();
		int m=in.nextInt();
		//if(m==0 && n==0) break;
		int total=(m*n);
		double a[]=new double[total];
		for(int i=0;i<total;i++){
			a[i]=in.nextDouble();
		}
		int t=in.nextInt();
		
			Arrays.sort(a);	
			double height = FindHeight(a[total-1],a[0], a,total,t);
			System.out.println("Region "+testcase);
			System.out.print("Water level is ");
			System.out.printf("%.2f",height);
			System.out.print(" meters.");
			System.out.println();
			double per=getPercent(height,a,total);
			System.out.printf("%.2f",per);
			System.out.println(" percent of the region is under water.");
			testcase++;
			System.out.println();
	}
	}

}
