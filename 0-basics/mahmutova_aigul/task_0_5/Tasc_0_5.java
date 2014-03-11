package task_0_5;
import java.util.Scanner;
public class Tasc_0_5 {
	public static double calcLn(int N) {
		if (N > 1) return (Math.log(N) + calcLn(N-1));
		return 0.0;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int N;
		System.out.print("введи N = ");
		N = in.nextInt();
        System.out.print("ln(N!) = " + calcLn(N));
		in.close();
	}
}
