import java.util.Scanner;


public class UVa272TEXQuotes {

	/**
	 * @param args
	 */
	private static Scanner in;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 in = new Scanner(System.in);  
           String line;  
           boolean open = true;  
           boolean end = false;  
           while(in.hasNextLine()) {  
                line = in.nextLine();  
                for(int i = 0; i < line.length(); i++) {  
                     if(line.charAt(i) == '\u001a'){  
                          end = true;  
                          break;  
                     }  
                     if(line.charAt(i) == '\"') {  
                          if(open == true) {  
                               System.out.print("``");  
                               open = false;  
                               continue;  
                          } else {  
                               System.out.print("''");  
                               open = true;  
                               continue;  
                          }  
                     }  
                     System.out.print(line.charAt(i));  
                }  
                System.out.print("\n");       
           }  
      }  
 }  