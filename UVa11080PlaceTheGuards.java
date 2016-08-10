import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class UVa11080PlaceTheGuards {
	private static Scanner in;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		in = new Scanner(System.in);
		int testCase = in.nextInt();
		
		while((testCase--)>0){
			int ans=0;
			boolean twocolor=true;
			int v = in.nextInt();
			int e = in.nextInt();
			List<Integer> graph[] = new List[v];
			
			Stack<Integer> st = new Stack<Integer>();
			boolean color[] = new boolean[v];
			boolean marked[] = new boolean[v];
			for(int i=0;i<v;i++) {
				graph[i] = new LinkedList<Integer>();
				color[i]=false;
				marked[i]=false;
			}
			for(int i=0;i<e;i++){
				int x = in.nextInt();
				int y= in.nextInt();
				graph[x].add(y);
				graph[y].add(x);
			}
			
			for(int i=0;i<v;i++){
				
				if(marked[i]==false){
					int ansMin=0,ansMax=0;
					int source =i;
					st.push(source);
					int s=0;
					while(!st.isEmpty()){
						s=st.pop();
						if(color[s]==false) ansMin++;
						else ansMax++;
						//System.out.print(s+" ");
						marked[s]=true;
						Iterator<Integer> it = graph[s].iterator();
						while(it.hasNext()){
							int tmp = it.next();
							if(marked[tmp]==false){
								st.push(tmp);
								marked[tmp]=true;
								color[tmp]=!color[s];
								
							}
							else if (color[tmp]==color[s]) twocolor=false;
						}
					}
					if (ansMin==0 || ansMax==0) ans+=Math.max(ansMin, ansMax);
					else ans += Math.min(ansMin, ansMax);
				}
				
				
				}
			
			
			if(e==0) ans = v;
			else if(twocolor) {
				ans =ans;
				
			}
			else ans=-1;
			System.out.println(ans);
		}
	}

}
