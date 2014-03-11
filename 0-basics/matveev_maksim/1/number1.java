package mma1;

import java.util.*;
public class number1 { //Ar_bool
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Random rd = new Random();
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		System.out.println();
		
		boolean[][] ar = new boolean[n][m];
		
		System.out.print("  ");
		for(int i=0;i<m;i++){
			System.out.print(i);
			System.out.print(" ");
		}
		 System.out.println();
		 
		for(int i=0;i<n;i++){
			System.out.print(i);
			System.out.print(' ');
			for(int j=0;j<m;j++){
				ar[i][j] = rd.nextBoolean();
				if (ar[i][j])
					System.out.print("* ");
				else
					System.out.print("_ ");
			}
			System.out.println();
		}
	}
}

