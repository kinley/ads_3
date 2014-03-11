package domashka;
import java.util.*;
class number1
{
	
	
	public static void main(String[] args) 
	{
		int n,m;
		Random rnd = new Random();
		Scanner sc = new Scanner(System.in);
		System.out.println("Size n:");
		n = sc.nextInt();
		System.out.println("Size m:");
		m = sc.nextInt();
		boolean[][] array = new boolean[n][m];
		System.out.print(" ");
		for(int i = 0; i < m; i++)
		{
			System.out.print(i+1);
			System.out.print(" ");
		}
		for(int i = 0; i < n; i++)
		{
			System.out.println();
			System.out.print(i+1);
			for(int j = 0; j < m; j++)
			{
				array[i][j] = rnd.nextBoolean();			
				if(array[i][j])
					System.out.print("* ");
				else
					System.out.print("# ");
			}
			
		}
		sc.close();
	}
	
	

	
}