import java.util.Scanner;


public class ACID2 {

	public static void main(String[] args) 
	{
		String str;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your string");
		str=sc.next();
		String str2 = new StringBuffer(str).reverse().toString();
		if (str.equals(str2))
			System.out.println("This string is palindrom");
		else
			System.out.println("This string is not palindrom");
		
		


	}

}
