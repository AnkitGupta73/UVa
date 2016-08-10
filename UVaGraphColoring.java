import java.io.IOException;
import java.util.Scanner;


public class UVaGraphColoring {
	
  public static int TestCases;
	public static int First, Second, MinimumNumberOfWhite;
	public static boolean[][] Matrix;
	public static int [] Color;
	public static int[] Chosen;
	public static int NumberOfNodes, Edges;
	private static Scanner input;
	public static void FindColor(int Index, int White){
		if(Index > NumberOfNodes){
			if(White < MinimumNumberOfWhite){
				MinimumNumberOfWhite = White;
				Chosen = Color.clone();
			}
		}else{
			boolean Black = true;
			for(int i = 0; i < Matrix.length; i++){
				if(Matrix[Index][i])	Black = Black && Color[i] != 2;
			}if(Black){
				Color[Index] = 2;
				FindColor(Index + 1, White);
				Color[Index] = 0;
			}
			Color[Index] = 1;
			FindColor(Index + 1, White + 1);
			Color[Index] = 0;
		}
	}
	
	public static void main(String args[]) throws NumberFormatException, IOException{
		input = new Scanner(System.in);
		
		TestCases = input.nextInt();
		while(TestCases-- > 0){
			NumberOfNodes = input.nextInt();
			Edges		  = input.nextInt();
			Matrix  = new boolean[NumberOfNodes + 1][NumberOfNodes + 1];
			
			for(int i = 0; i < Edges; i++){
				First  = input.nextInt();
				Second = input.nextInt();
				Matrix[First][Second] = Matrix[Second][First] = true;
			}
			Color = new int[NumberOfNodes + 1];
			MinimumNumberOfWhite = NumberOfNodes;
			
			FindColor(1, 0);
			System.out.println(NumberOfNodes - MinimumNumberOfWhite);
			int CounterSpace = 0;
			
			for(int i = 1; i < Chosen.length; i++){
				if(Chosen[i] == 2){
					if(CounterSpace != 0)
						System.out.print(" " + i);
					else
						System.out.print(i);
					CounterSpace++;
				}
					
			}
			System.out.println();
			
			
			
		}
		
		
	}
		
}
	