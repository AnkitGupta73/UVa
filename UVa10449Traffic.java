import java.util.Scanner;

public class UVa10449Traffic {
	private static Scanner in;
	private static double distance(int[] a,int u,int v){
		double tmp = a[v]-a[u];
		tmp = tmp*tmp*tmp;
		return tmp;
	}
	private static int minDistance(double dist[], Boolean sptSet[],int V)
    {
        // Initialize min value
        double min = Integer.MAX_VALUE; 
        int min_index=-1;
 
        for (int v = 0; v < V; v++)
            if (sptSet[v] == false && dist[v] <= min)
            {
                min = dist[v];
                min_index = v;
            }
 
        return min_index;
    }
	private static void dijkstra(double graph[][], int src,int V)
    {
        double dist[] = new double[V]; // The output array. dist[i] will hold
                                 // the shortest distance from src to i
 
        // sptSet[i] will true if vertex i is included in shortest
        // path tree or shortest distance from src to i is finalized
        Boolean sptSet[] = new Boolean[V];
 
        // Initialize all distances as INFINITE and stpSet[] as false
        for (int i = 0; i < V; i++)
        {
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }
 
        // Distance of source vertex from itself is always 0
        dist[src] = 0;
 
        // Find shortest path for all vertices
        for (int count = 0; count < V-1; count++)
        {
            // Pick the minimum distance vertex from the set of vertices
            // not yet processed. u is always equal to src in first
            // iteration.
            int u = minDistance(dist, sptSet,V);
 
            // Mark the picked vertex as processed
            sptSet[u] = true;
 
            // Update dist value of the adjacent vertices of the
            // picked vertex.
            for (int v = 0; v < V; v++)
 
                // Update dist[v] only if is not in sptSet, there is an
                // edge from u to v, and total weight of path from src to
                // v through u is smaller than current value of dist[v]
                if (!sptSet[v] && graph[u][v]!=0 &&
                        dist[u] != Integer.MAX_VALUE &&
                        dist[u]+graph[u][v] < dist[v])
                    dist[v] = dist[u] + graph[u][v];
        }
 
        // print the constructed distance array
     //   printSolution(dist, V);
        int q = in.nextInt();
        for(int tp = 0; tp<q;tp++){
        	int tmp = in.nextInt();
        	if (dist[tmp-1]<3) System.out.println("?");
        	else System.out.println((int)dist[tmp-1]);
        }
        
    }
	
	/*
	private static void printSolution(double dist[], int n)
    {
        System.out.println("Vertex   Distance from Source");
        for (int i = 0; i < n; i++)
            System.out.println(i+" \t\t "+dist[i]);
    }*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		in = new Scanner(System.in);
		int set=1;
		while(in.hasNextLine()){
			int n = in.nextInt();
			System.out.println("Set #"+set);
			set++;
			if(n>0){
			int a[] = new int[n];
			for(int i=0;i<n;i++){       
				 a[i] = in.nextInt();
			}
			int r = in.nextInt();
			double graph[][] = new double[n][n];
			for(int i=0;i<r;i++){
				int u = in.nextInt()-1;
				int v = in.nextInt()-1;
				graph[u][v] = distance(a,u,v);
				graph[v][u] = graph[u][v];
			}
			
			
			
			
				dijkstra(graph, 0,n);
			}
		}
		
	}

}
