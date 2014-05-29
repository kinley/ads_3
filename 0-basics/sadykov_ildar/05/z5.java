
import java.util.Scanner;

public class z5 {
	
	public static double Log (long n)
	{
		if(n>1) return Math.log(n)+Log(n-1);
		return 0;
	}
	
	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
		long n = in.nextInt();
		in.close();
		System.out.println(Log(n));
	}	
}
