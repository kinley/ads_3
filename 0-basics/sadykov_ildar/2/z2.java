

import java.util.Scanner;

public class z2
{
	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Enter string:");
		String s = in.next();
		in.close();
		int l=s.length();
		
		boolean T=true; int i=0;
		while(T&&(i<l/2))
		{
			if(s.charAt(i)!=s.charAt(l-i-1)) T=false;
			i++;
		}
		
		System.out.println("String is palindrom: " + T);
	}
}
