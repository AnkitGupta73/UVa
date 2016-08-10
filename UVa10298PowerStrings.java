import java.util.Scanner;

public class UVa10298PowerStrings {
	private static Scanner in;
	private static int[] preCompute(int a[],char c[],int l){
		a[0]=0;
		int i=1;
		int j=0;
		while (i<l){
			if(c[i]==c[j]){
				a[i]=j+1;
				i++;
				j++;
			}
			else if (j>0) j=a[j-1];
			else {
				a[i]=0;
				i++;
			}
			
		}
	//	for(i=0;i<l;i++) System.out.print(a[i]+" ");
		return a;
	}
	
	private static int kmp(char[] pat, char[] txt,int n,int m,int[] lps){
		int ans=0;
		int i=0,j=0;
		while (i < n)
	    {
	      if (pat[j] == txt[i])
	      {
	        j++;
	        i++;
	 //       ans = max(ans,j);
	      }
	 
	      if (j == m)
	      {
	  //  	  System.out.println("match at: "+(i-j));
	    	  ans++;
	    	  j = lps[j-1];
	        
	      }
	 
	      // mismatch after j matches
	      else if (i < n && pat[j] != txt[i])
	      {
	        // Do not match lps[0..lps[j-1]] characters,
	        // they will match anyway
	        if (j != 0)
	         j = lps[j-1];
	        else
	         i = i+1;
	      }
	    }
		return  ans-1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		in = new Scanner(System.in);
		//int testCase = in.nextInt();
		while(true){
			String text = in.next();
			if(text.equals(".")) break;
			//int l = pattern.length();
		//	String pattern = new StringBuffer(text).reverse().toString();
			String pattern=text;
			text = text+text;
			int n = text.length();
			char txt[] = text.toCharArray();
			
			char pat[] = pattern.toCharArray();
			int m = pattern.length();
			int lps[] = new int[m];
			lps = preCompute(lps,pat,m);
			int ans=kmp(pat, txt, n, m, lps);
			
		//	System.out.println("Answer: "+ans);
			//System.out.println("Answer: "+ans);
			
		//	if(ans==m) System.out.println("palindrome");
		//	else if(ans==-1)System.out.println("simple");
		//	else System.out.println("alindrome");
		//	System.out.println("the Answer: "+ans);
			System.out.println(ans);
			
			
		}
	}

}
