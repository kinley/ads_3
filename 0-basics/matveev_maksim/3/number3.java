package mma1;

import java.util.*;

public class number3 { //printf

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String st = sc.next();
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		System.out.printf("%10s","   Name   ");
		System.out.printf("%10s"," A ");
		System.out.printf("%10s"," B ");
		System.out.printf("%10s","  A/B ");
		System.out.println();
		
		System.out.printf("%8s %10d %9d %10.3f\n",st,a,b,(double)a/b);
	} 
}
