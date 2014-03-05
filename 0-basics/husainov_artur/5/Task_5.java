package pkg0zadanie;

import static java.lang.Math.log;
import java.util.Scanner;

public class Task_5 {
    	private static double ln_fact(double n){
		if(n==1) return 0;
		else return log(n) + ln_fact(n-1);
	}	
	public static void main(String[] args){
                System.out.print("Введите N: ");
		Scanner in = new Scanner(System.in);
		double N = in.nextDouble();
		System.out.printf("%s %-10.3f\n","Ответ: ln(N!)=",ln_fact(N));
		in.close();
	}   
}
