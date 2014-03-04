package domashka;
import java.util.*;
public class number5 {

	public static double logfactorial(int n)
	{
		if(n==1)
			return 0;
		else
			return logfactorial(n-1)+Math.log(n);
	}
	
	public static void main(String[] args) {
		
		
		
		System.out.println(logfactorial(4));
		System.out.println(Math.log(24));
	}

}
