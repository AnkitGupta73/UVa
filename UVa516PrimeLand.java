import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class UVa516PrimeLand {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		boolean prime[] = new boolean[338688];
		Arrays.fill(prime, true);
		prime[0]=prime[1]=false;
		for(int i=2;i<32768;i++){
			if(prime[i]){
				for(int j=i*i;j<338688;j+=i){
					prime[j]=false;
				}
				
			}
		}
		//for(int i=0;i<32768;i++) 
		//	if(prime[i])System.out.println(i);
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			String[] arr=in.readLine().split(" ");
			int[] intarr=new int[arr.length];

			for(int i=0;i<arr.length;i++)
			 intarr[i]=Integer.parseInt(arr[i]);
			
			if(intarr[0]==0) break;
			
			int tmp = 1;
			for(int i=0;i<arr.length;i+=2){
				while((intarr[i+1]--)>0){
					tmp = tmp*intarr[i];
				}
			}
			//System.out.println(tmp);
			tmp--;
			int ans[] = new int[338688];
			int freq[] = new int[338688];
			int count=0;
		//	System.out.println("tmp= "+tmp);
			for(int i=tmp;i>0;i--){
				if(prime[i] && tmp%i==0){
					ans[count]=i;
					freq[count]++;
					tmp=tmp/i;
					while(tmp%i==0){
						freq[count]++;
						tmp=tmp/i;
					}
					count++;
				}
			}
			for(int i=0;i<count-1;i++){
				System.out.print(ans[i]+" "+freq[i]+" ");
			}
			
			System.out.println(ans[count-1]+" "+freq[count-1]);
		}
		
		
		
		

	}

}
