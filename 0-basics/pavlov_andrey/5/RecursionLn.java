import java.util.Scanner;


public class RecursionLn {
	
	private static Scanner input;

	public static double ln_factorial(int x){
		if(x==1) 
			return 0;
		else
			return Math.log(x)+ln_factorial(x-1);
	}
	
	public static void main(String []arg){
		System.out.println("¬ведите число");
		input = new Scanner(System.in);
		String x=input.next();
		int y=Integer.parseInt(x);
		System.out.println("ln("+x+"!)="+ln_factorial(y));
	}

}
