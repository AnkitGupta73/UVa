import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UVa1056DegreesOfSeparation {
	private static Scanner in;
	
	private static int allPairShortestPath(int[][] a,int v){
		int distance[][] = new int[v][v];
		distance = a;
		for(int k=0;k<v;k++){
			for(int i=0;i<v;i++){
				for(int j=0;j<v;j++){
					if (distance[i][k] + distance[k][j] < distance[i][j])
						distance[i][j] = distance[i][k] + distance[k][j];
				}
			}
		}
		int max=-1;
		for(int i=0;i<v;i++){
			for(int j=0;j<v;j++){
			//	System.out.print(distance[i][j]+" ");
				//if(max<distance[i][j]) max = distance[i][j];
			}
		//	System.out.println();
		}
		
		return max;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		in = new Scanner(System.in);
		int num=1;
		while(true){
			int p=in.nextInt();
			int r = in.nextInt();
			if(p==0 && r==0) break;
			//else if(num!=1) System.out.println();
			String ppl[] = new String[p];
			Map<String,Integer> testMap = new HashMap<String,Integer>();
			int point=0;
			int graph[][] = new int[p][p];
			for(int i=0;i<p;i++){
				for(int j=0;j<p;j++){
				if(i!=j)	graph[i][j]=9999999;
				}
			}
			
			for(int i =0;i<r;i++){
				String s1 = in.next();
				String s2 = in.next();
				int t1=-1,t2=-1;
				for(int j=0;j<p;j++){
					if(s1.equals(ppl[j])) t1=j;
					if(s2.equals(ppl[j])) t2=j;
				}
				if(t1==-1){
					ppl[point] = s1;
					testMap.put(s1, point);
					point++;
				}
				if(t2==-1){
					ppl[point] = s2;
					testMap.put(s2,point);
					point++;
				}
			    graph[testMap.get(s1)][testMap.get(s2)]=1;
			    graph[testMap.get(s2)][testMap.get(s1)]=1;
			  //  System.out.println(testMap.keySet());
			   // System.out.println(testMap.values());
			}
			/*
			for(int i=0;i<p;i++){
				for(int j=0;j<p;j++){
					System.out.print(graph[i][j]+" ");
				}
				System.out.println();
			}
			System.out.println();
			*/
			System.out.print("Network "+num+": ");
			int ans = allPairShortestPath(graph,p);
			if(ans==9999999) System.out.println("DISCONNECTED");
			else System.out.println(ans);
			System.out.println();
			num++;
		}
	}

}
