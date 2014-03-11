package ru.kpfu.ivmiit;

import java.util.Scanner;

public class Palindrom {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		String word=scanner.next();
		int i=0;
		boolean isPalindrom=true;
		while(isPalindrom && i<word.length()/2){
			isPalindrom=word.charAt(i)==word.charAt(word.length()-i-1);
			i++;
		}
		System.out.println(isPalindrom);
		scanner.close();
	}
}
