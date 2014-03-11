package ru.kpfu.ivmiit;

import java.util.Scanner;

public class GCDWriter {
	public  int gcd(int p, int q) {
		while (q != 0) {
			int res = p % q;
			p = q;
			q = res;
			System.out.println(p+", "+q);
		}
		return p;
	}
	public static void main(String[] args){
		GCDWriter writer=new GCDWriter();
		Scanner scanner=new Scanner(System.in);
		int p=scanner.nextInt();
		int q=scanner.nextInt();
		writer.gcd(p, q);
		scanner.close();
	}
}
