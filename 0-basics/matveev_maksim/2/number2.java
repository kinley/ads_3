package mma1;

import java.util.*; 

public class number2 { //Palindrome

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String st = sc.next();
		boolean pr = true;
		int i=0, j=st.length()-1;

		while (pr && i<=(st.length()+1)/2){
			if(st.charAt(i) != st.charAt(j))
				pr = false;
			else{
				i++;
				j--;
			}	
		}
		if (pr)
			System.out.println("Palindrome!");
		else
			System.out.println("Is not a palindrome!");
	}
}
