import java.util.Scanner;


public class UVa957Popes {

	private static Scanner in;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		in = new Scanner(System.in);
		while(in.hasNext()){
			int y = in.nextInt();
			int p = in.nextInt();
			int yrs[] = new int[p];
			for(int i=0;i<p;i++){
				yrs[i]=in.nextInt();
			}
			int j=0;
			int max = Integer.MIN_VALUE;
			int start=-1,end=-1;
			for(int i=0;i<p;i++){
				j=i;
				int count=0;
				while(j<p && yrs[j]< yrs[i]+y){
					count++;
					j++;
				}
				if(count>max){
					max = count;
					start = yrs[i];
					end=yrs[j-1];
				}
			}
			System.out.println(max+" "+start+" "+end);
			
		}
	}

}
