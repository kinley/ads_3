package mma1;

import java.util.*;

public class number4 { //NOD
	
	static int nod(int a, int b){
		if(b==0)
			return a;
		return nod(b,a%b);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		System.out.println(nod(a,b));
	}
}
