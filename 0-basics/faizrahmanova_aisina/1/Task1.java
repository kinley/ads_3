import java.util.Scanner;
public class Task1 {
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter N:");
		int N=sc.nextInt();
		boolean[][] a=new boolean[N][N];
		int i=0, j=0;
		for(i=0;i<N;i++)
			for(j=0;j<N;j++)
				{
				if((i==j)||(j==N-i-1)||(i==N/2))
				a[i][j]=true;
				else a[i][j]=false;				
				}
		System.out.print("  ");
		for(i=0;i<N;i++)
			System.out.print(i+1+" ");
		System.out.println("\n");
		for(i=0;i<N;i++)
			{System.out.print(i+1+" ");
			for(j=0;j<N;j++)
			{
				
				if(a[i][j]==true) System.out.print("*"+" ");
				else System.out.print(" "+" ");
			}
			System.out.println("\n");
			}
		sc.close();
		
			
	}

}
