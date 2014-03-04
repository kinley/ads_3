package zadanie0;

import java.util.Random;

public class Z01 {
	private static int N = 9;
	private static int M = 11;
	private static Boolean arr[][] = new Boolean [N][M]; 
	private static Random rnd = new Random();
	public static void main(String[] args){
		System.out.print(" ");
		for(int k=1;((M>10) ? k<=10 : k<=M);k++)
			System.out.print("  " + k);
		if(M>10)
			for(int p=11;p<=M;p++)
				System.out.print(" " + p);
		System.out.print('\n');
		for(int i=0;i<N;i++){
			System.out.print(i+1);
			for(int j=0;j<M;j++){
				arr[i][j] = rnd.nextBoolean();
				System.out.print(((arr[i][j]) ? "  *" : "   "));
			}
			System.out.print('\n');
		}
	}
}
