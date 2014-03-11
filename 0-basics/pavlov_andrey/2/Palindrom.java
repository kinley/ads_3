import java.util.Scanner;


public class Palindrom {

	private static Scanner input;

	static boolean CheckString(String a){
		boolean flag=true;
		int length = a.length();
		for(int i=0;i<length/2&&flag;++i)
			if(a.charAt(i)!=a.charAt(length-1-i))
				flag=false;
		return flag;
	}
	
	public static void main(String []arg){
		System.out.println("Введите слово");
		input = new Scanner(System.in);
		String word=input.next();
		if(!CheckString(word))
			System.out.println("Слово не является полиндромом");
		else
			System.out.println("Слово полиндром");
	}
}
