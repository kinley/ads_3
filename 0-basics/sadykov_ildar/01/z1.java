
import java.util.Random;
import java.util.Scanner;

public class z1
{	
	public static boolean[][] NewMatrix()
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		in.close();
		boolean A[][] =new boolean [n][m];
		Random r = new Random();
		for (int i=0; i<n; i++)
		{
			for (int j=0; j<m; j++)
				{
				A[i][j]=r.nextBoolean(); 
				}			
		}
		return A;
	}	
	
	public static void ShowMatrix(boolean A[][])
	{
		int n=A.length;						//количество строк
		int m=A[0].length;					//количество столбцов
		
		System.out.print(' ');
		
		for (int k=1; k<=m; k++)
		{
			System.out.printf("%5d ", k);	//вывод номера столбца			
		}
		System.out.println();
		
		for (int i=0; i<n; i++)
		{			
			System.out.print(i);			//вывод номера строки
			
			for (int j=0; j<m; j++)
				{					
				if (A[i][j]) System.out.printf("%5s ","*");
					else System.out.printf("%5s ","");					
				}
			System.out.println();
		}	
	}
	
	public static void main(String[] args) 
	{
		boolean A[][]=NewMatrix();
		ShowMatrix(A);	
	}
}