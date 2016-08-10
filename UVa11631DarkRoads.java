import java.util.Arrays;
import java.util.Scanner;
class edge implements Comparable<edge>{
	int f,t;
	int w;
	@Override
	public int compareTo(edge o) {
		return this.w-o.w;
	}
}
public class UVa11631DarkRoads {
	static int root[];
	static int size[];
	private static Scanner sc;
	public static void main(String args[]){
		sc = new Scanner(System.in);
		int v = sc.nextInt();
		int e = sc.nextInt();
		while(v!=0 && e!=0){
			int i;
			long sum = 0; 
//			boolean visited[] = new boolean[v+1];
			edge graph[] = new edge[e];
			for(i=0;i<e;i++){
				graph[i] = new edge();
				graph[i].f = sc.nextInt();
				graph[i].t = sc.nextInt();
				graph[i].w = sc.nextInt();
				sum+=graph[i].w;
			}
			Arrays.sort(graph);
			root = new int[v+1];
			size = new int[v+1];
			for(i=1;i<=v;i++){
				root[i]=i;
				size[i]=1;
			}
			int cnt=0;
			i=0;
			while(cnt<v-1){
				if(insert(graph[i])){
					//System.out.println("edge inserted "+graph[i].f+" "+graph[i].t);
					sum-=graph[i].w;
					cnt++;
				}
				i++;
			}
			System.out.println(sum);
			v = sc.nextInt();
			e = sc.nextInt();
		}
	}
	private static boolean insert(edge ed) {
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