package mma1;

import java.util.*;

public class number5 { //log_fact_n
	
	static double log_fact(int n){
		if(n==1)
			return 0;
		else
			return Math.log(n) + log_fact(n-1);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(log_fact(n));
	}
}
