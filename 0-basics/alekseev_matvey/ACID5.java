import java.util.Scanner;


public class ACID5 {
	static double metod(int a)
	{
		if (a==1) 
				return 0;
		else
			{double sum=Math.log(a);
			sum=sum+metod(a-1);
			return sum;}
	}
	public static void main(String[] args) 
	{
		int first;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter N");
		first=sc.nextInt();
		System.out.print("ln(N!)=");
		System.out.println(metod(first));		
	}

}
