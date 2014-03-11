package task_0_1;
import java.util.Scanner;
import java.util.Random;
public class Task_0_1 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("кол-во строк M=");
		Scanner in = new Scanner(System.in);
		int M = in.nextInt();
		System.out.print("кол-во столбцов N=");
		int N = in.nextInt();
		boolean [][] a = new boolean [M][N];
		Random r = new Random();
		for (int i = 0; i < M; i++)
			for (int j = 0; j < N; j++)
					a[i][j] = r.nextBoolean();
		System.out.println("Mатрица:");
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++)
				System.out.print(a[i][j] + " ");
			System.out.println();
		}
		System.out.println("Mатрица:");
		for (int j = 0; j <= N; j++) {
			System.out.print(j + " ");
		}
		System.out.println();
		for (int i = 0; i < M; i++) {
			System.out.print((i+1) + " ");
			for (int j = 0; j < N; j++)
				{
					if (a[i][j]) System.out.print("* ");
					else System.out.print("  ");
				}
			System.out.println();
		}
		in.close();
	}
}
