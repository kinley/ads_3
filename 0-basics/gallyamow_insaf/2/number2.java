package domashka;
import java.util.*;
class number2
{
	
	
	public static void main(String[] args) 
	{
		String str = new String();
		Scanner sc = new Scanner(System.in);
		System.out.println("Print str:");
		str = sc.next();
		boolean E = true;
		for(int i = 0; i <= (str.length()+1)/2 && E; i++)
		{
			if(str.charAt(i) != str.charAt(str.length()-i-1))
				E = false;
		}
		if(E)
			System.out.println("Palindrom");
		else
			System.out.println("No");
		sc.close();
	}
	
	

	
}