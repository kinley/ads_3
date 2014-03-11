package ru.kpfu.ivmiit;

import java.util.Scanner;

public class LnCalculator {
	private static double ln(int n){
		return (n>1? Math.log(n)+ln(n-1):0);
	}
	public static void main(String[] args){
		Scanner scanner=new Scanner(System.in);
		System.out.println(ln(scanner.nextInt()));
		scanner.close();
	}
}
