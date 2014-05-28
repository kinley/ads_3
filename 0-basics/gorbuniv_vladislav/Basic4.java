package apa2;

import java.util.Scanner;

public class Basic4 {
	private static int gcd(int p, int q){
		System.out.printf("p = %-10d q = %d \n", p, q);
		if (q == 0) return p;
        int x = p % q;
        return gcd(q, x);
	}

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int p = in.nextInt();
		int q = in.nextInt();
		System.out.println("Result is: " + gcd(p,q));
		in.close();
	}
}
