import java.util.*;
public class UVa11988BrokenKeyboard {

	private static Scanner in;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		in = new Scanner(System.in);
		
		int pos=0;
		boolean home =false;
		
		while(in.hasNext()){
			String str = in.next();
			char c[] = str.toCharArray();
			LinkedList<Character> list = new LinkedList<Character>();
			Iterator<Character> it;
			pos=0;
			for(int i=0;i<str.length();i++){
				if(c[i]=='['){
					home =true;
					pos=0;
				}
				else if(c[i]==']'){
					home =false;
				}
				else if(home){
					list.add(pos++,c[i]);
				}
				else{
					list.add(c[i]);
				}
			}
			it =list.iterator();
			while(it.hasNext()){
				System.out.print(list.poll());
			}
			System.out.println();
			
		}

	}

}
