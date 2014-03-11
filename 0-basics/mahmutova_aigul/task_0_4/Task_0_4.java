package task_0_4;
import java.util.Scanner;
public class Task_0_4 {
	public static int gcd(int p, int q) {
		if (q == 0) return p;
		int r = p%q;
		System.out.println("r= " + r);
		return gcd (q, r);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.print("p = ");
		int p = in.nextInt();
		System.out.print("q = ");
		int q = in.nextInt();
		int g = gcd(p, q);
		System.out.print("мнд(p, q)= " + g);
		in.close();
	}
}
