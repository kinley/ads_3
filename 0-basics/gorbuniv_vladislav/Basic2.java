package apa2;
import java.util.Scanner;

	public class Basic2 {
		private static boolean isPalindrom(String word){
			return word.equalsIgnoreCase(new StringBuilder(word).reverse().toString());
		}
	
		public static void main(String[] args){
			Scanner in = new Scanner(System.in);
			String word = in.next();
			System.out.println((isPalindrom(word) ? "isPalindrom" : "NotPalindrom"));
			in.close();
		}
	}
	
