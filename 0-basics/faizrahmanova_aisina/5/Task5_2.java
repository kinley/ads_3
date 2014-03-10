
import java.util.Scanner;

public class Task5_2 {
	
	public static double ln_fact(int x)
	{
		if(x<=0) return -1;
		if(x==1) return 0;
		else return Math.log(x)+ln_fact(x-1);
	}
	
				
	
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter N:");
		int N=sc.nextInt();
		
		System.out.println("ln(N!): "+ln_fact(N));
		
		sc.close();
		

	}

}

