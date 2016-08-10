import java.util.Scanner;

public class UVa11505Logo {
	public static Scanner in;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		in = new Scanner(System.in);
		int t = in.nextInt();
		while((t--)>0){
			double x =0;
			double y=0;
			double angle=0;
			int n = in.nextInt();
			for(int i=0;i<n;i++){
				String s= in.next();
				double d = in.nextDouble();
				if(s.equals("fd")){
					x+=d*Math.cos(Math.toRadians(angle));
					y+=d*Math.sin(Math.toRadians(angle));
				}
				else if(s.equals("bk")){
					x-=d*Math.cos(Math.toRadians(angle));
					y-=d*Math.sin(Math.toRadians(angle));
				}
				else if(s.equals("lt")){
					angle+=d;
				}
				else if(s.equals("rt")){
					angle -= d;
				}
			//	System.out.println("Position: x="+x+" y="+y+" 0="+angle );
				
			}
			System.out.println((int) Math.round(Math.sqrt(x*x + y*y)));
		}
	}

}
