package task_0_2;
import java.util.Scanner;
public class Task_0_2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.print("строка s = ");
		String s = in.nextLine();
		s = s.toLowerCase();
		int n = s.length();
		int i = 0, k = n-1;
		boolean b = true;
		while (i <= k && b) {
			while (!(s.charAt(i) >= 'a' && s.charAt(i) <= 'z' || s.charAt(i) >= '0' && s.charAt(i) <= '9')) {
				i++;
			}
			while (!(s.charAt(k) >= 'a' && s.charAt(k) <= 'z' || s.charAt(k) >= '0' && s.charAt(k) <= '9')) {
				k--;
			}
			if (s.charAt(i) == s.charAt(k)) {
				i++;
				k--;
			}
			else b = false;
		}
		if (b) System.out.println("yes");
		else System.out.println("no");
		in.close();
	}
}
