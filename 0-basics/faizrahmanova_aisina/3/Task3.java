import java.util.Scanner;

public class Task3 {
	public static void main(String[] args)
	{
		int a=0, b=0;
		
		System.out.println("Введите * для завершения:");
        Scanner sc=new Scanner(System.in);
		String s;
		s=sc.next();
		
		while(s!="*"){	
			
		System.out.printf("%-10s |", s);		
		///s=sc.next();
		//a=Integer.parseInt(s);
		a=sc.nextInt();
		System.out.printf(" %d |", a);
		///s=sc.next();
		//b=Integer.parseInt(s);
		b=sc.nextInt();
		System.out.printf(" %d |", b);
		
		
		double d=(double)a/(double)b;
		System.out.printf(" %.3f  \n", d);
		
		s=sc.next();
		}		
		
		sc.close();
			
	}
	

}
