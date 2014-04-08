import java.util.Scanner;


public class ACID3 {

	public static void main(String[] args)
	{
		int b,c;
		String str;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter first nimber");
		b=sc.nextInt();
		System.out.println("Enter second nimber");
		c=sc.nextInt();
		System.out.println("Enter String");
		str=sc.next();
		Double bc=(double) b/c;
		System.out.printf(str);
		System.out.printf("%7d", b);
		System.out.printf("%7d", c);
		System.out.printf("%7.3f", bc);
		System.out.println();

	}

}
