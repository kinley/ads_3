import java.util.Scanner;

public class Task5_1 {
	
	public static int factor(int x)
	{
		if(x<0) return 0;
		if((x==0)||(x==1)) return 1;
		else return x*factor(x-1);
	}	
				
	
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter N:");
		int N=sc.nextInt();
		
		System.out.println("ln(N!) : "+Math.log(factor(N)));
		sc.close();
		

	}

}
