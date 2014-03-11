package zadanie0;

import java.util.Scanner;

public class Z02 {
	private static boolean isPalindrome(String word){
		return word.equalsIgnoreCase(new StringBuilder(word).reverse().toString());
	}
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		String word = in.next();
		System.out.println((isPalindrome(word) ? "^_^" : "T_T"));
		in.close();
	}
}
