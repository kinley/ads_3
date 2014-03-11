import java.util.Random;

public class BoolArray {
	private static final int N = 10;
	private static final int M = 7;
	
	static boolean[][] FillArray(boolean [][]a){
		Random rand=new Random();
		for(int i=0; i<N; ++i)
			for(int j=0; j<M; ++j)
			a[i][j]= rand.nextBoolean();
		
		return a;
	}
	
	static void ShowArray(boolean [][]a){
		
		for(int i=0;i<M;++i)
		System.out.print(" "+i);
		System.out.println();
	    
		for(int i=0;i<N;++i)
	      {System.out.print(i);
	    	for(int j=0;j<M;++j)
			{
	    	  if(a[i][j]==true)
	        	System.out.print("* ");
			else
				System.out.print("  ");
			}
	      System.out.println();
	        }
	    }
	

	public static void main(String []arg){
	boolean [][]b_array=new boolean[N][M];
	FillArray(b_array);
	ShowArray(b_array);
	
	}

}
