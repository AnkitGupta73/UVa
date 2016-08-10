import java.util.Arrays;
import java.util.Scanner;
class edge1 implements Comparable<edge1>{
	int f,t;
	double w;
	@Override
	public int compareTo(edge1 o) {
		double b = this.w-o.w;
		if (b<0) return -1;
		else if(b==0) return 0;
		return 1;
		//return this.w-o.w;
	}
}

public class UVa10369ArcticNetwork {
	static int root[];
	static int size[];
	private static Scanner sc;
	public static void main(String args[]){
		sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		
		while((testCase--)>0){
		int s = sc.nextInt();
		int v = sc.nextInt();
		
			int i;
//			long sum = 0; 
//			boolean visited[] = new boolean[v+1];
			int e=(v*(v+1)/2)+2;
			edge1 graph[] = new edge1[e];
			int xy[][]= new int[2][v+1];
			for(i=0;i<v;i++){
				xy[0][i] = sc.nextInt();
				xy[1][i] = sc.nextInt();
			}
			int k=0;
			for(i=0;i<e;i++) graph[i] = new edge1();
			
			for(i=0;i<v-1;i++){
				
				for(int j=i+1;j<v;j++){
						graph[k].f = i;
						graph[k].t = j;
						graph[k++].w = distance(xy[0][i],xy[0][j],xy[1][i],xy[1][j]); 	
				}
			}
			Arrays.sort(graph);
			root = new int[v];
			size = new int[v];
			for(i=0;i<v;i++){
				root[i]=i;
				size[i]=1;
			}
			int cnt=0;
			i=0;
			int answ=v;
			double last=0;
			while(cnt<v-1){
				if(insert(graph[i])){
					//System.out.println("edge inserted "+graph[i].f+" "+graph[i].t);
					//sum-=graph[i].w;
					last=graph[i].w;
					cnt++;
					answ--;
				}
				i++;
				if(answ==s) break;
				
			}
			System.out.printf("%.2f",last);
			System.out.println();
			
		}
		
	}
	private static double distance(int i, int j, int k, int l) {
		// TODO Auto-generated method stub
		double a = i-j;
		double b = k-l;
		a=a*a;
		b=b*b;
		return Math.sqrt(a+b);
	}
	private static boolean insert(edge1 ed) {
		int a = get_root(ed.f);
		int b = get_root(ed.t);
		if(a==b)return false;
		if(size[a]>=size[b]){
			root[b]=a;
			size[a]+=size[b];
			size[b]=0;
		}else{
			root[a]=b;
			size[b]+=size[a];
			size[a]=0;
		}
		return true;
	}
	private static int get_root(int t) {
		while(root[t]!=t)t=root[t];
		return t;
	}
}