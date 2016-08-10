import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class UVa11504Dominos {
	private static Scanner in;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		in = new Scanner(System.in);
		int testCase=in.nextInt();
		while((testCase--)>0){
		int n = in.nextInt();
		int m = in.nextInt();
		List<Integer> graph[] = new List[n+1];
		
		Stack<Integer> st = new Stack<Integer>();
		boolean incoming[] = new boolean[n+1]; 
		int color[] = new int[n];
		
		for(int i=0;i<n;i++){
			graph[i] = new LinkedList<Integer>();
			color[i]=0;	
		}
		for(int i=0;i<m;i++){
			int x = in.nextInt()-1;
			int y = in.nextInt()-1;
			graph[x].add(y);
			//graph[y].add(x);
			incoming[y]=true;
		}
		int ans=0;
		//int a[][] = new int[n][n];
		
		for(int i=0;i<n;i++){
			if(incoming[i]==false){
				ans++;
				int source=i;
				st.push(source);
				int s=0;	
				while(!st.isEmpty()){
					s=st.pop();
					//System.out.print(s+" ");
					color[s]=2;
					Iterator<Integer> it = graph[s].iterator();
					while(it.hasNext()){
						int tmp = it.next();
						if(color[tmp]==0){
							st.push(tmp);
							color[tmp]=1;
						}
					}
				}
		
			}
		
		}
		
		for(int i=0;i<n;i++){
			if(color[i]==0){
				Iterator<Integer> it = graph[i].iterator();
				while(it.hasNext()){
					int tmp = it.next();
					graph[tmp].add(i);
				}
			}
		}
		
		
		for(int i=0;i<n;i++){
			if(color[i]==0){
				ans++;
				int source=i;
				st.push(source);
				int s=0;	
				while(!st.isEmpty()){
					s=st.pop();
					//System.out.print(s+" ");
					color[s]=2;
					Iterator<Integer> it = graph[s].iterator();
					while(it.hasNext()){
						int tmp = it.next();
						if(color[tmp]==0){
							st.push(tmp);
							color[tmp]=1;
						}
					}
				}
		
			}
		
		}
		
		
		System.out.println(ans);
	}
	}
}
