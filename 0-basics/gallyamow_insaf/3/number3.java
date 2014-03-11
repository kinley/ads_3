package domashka;
import java.util.*;
public class number3 {

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		String str = new String();
		int a,b;
		System.out.printf("Enter Strings:");
		
		str = sc.next();
		a = sc.nextInt();
		b = sc.nextInt();
		
		System.out.printf("      Name      ");
		System.out.printf("  Number A   ");
		System.out.printf("  Number B   ");
		System.out.printf(" Number A/B \n");
		
		for(int i = 0; i < 1; i++)
		{
			
			
		    System.out.printf("%10s %12d %12d %12.3f\n", str, a, b, (double)a/b);

		}
		
	}

}
