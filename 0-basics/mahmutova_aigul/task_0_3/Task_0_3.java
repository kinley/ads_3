package task_0_3;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
public class Task_0_3 {
	public static int getMaxLengthOfWords(ArrayList<String> s) {
		int max = s.get(0).length();
		for (int i = 1; i < s.size(); i++)
			if (max < s.get(i).length()) max = s.get(i).length();
		return max;
	}
	public static int getLengthOfNumber(int n) {
		int l = 1;
		while (n >= 10) {
			l++;
			n = n/10;
		}
		return l;
	}
	public static int getMaxLengthOfNumber(ArrayList<Integer> s) {
		int max = getLengthOfNumber(s.get(0));
		for (int i = 1; i < s.size(); i++)
			if (max < getLengthOfNumber(s.get(i))) max = getLengthOfNumber(s.get(i));
		return max;
	}
	public static int getMaxLengthOfNumber(ArrayList<Integer> s, ArrayList<Integer> s1) {
		int max = getLengthOfNumber((int) s.get(0)/s1.get(0));
		for (int i = 1; i < s.size(); i++)
			if (max < getLengthOfNumber((int) s.get(i)/s1.get(i))) max = getLengthOfNumber((int) s.get(i)/s1.get(i));
		return max;
	}
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		File file = new File("input.txt");
		ArrayList<String> s = new ArrayList<String>();
		ArrayList<Integer> a = new ArrayList<Integer>();
		ArrayList<Integer> b = new ArrayList<Integer>();
		try {
			Scanner in = new Scanner(file);
			while (in.hasNextLine()) {
				s.add(in.next());
				a.add(in.nextInt());
				b.add(in.nextInt());
			}
			in.close();
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < s.size(); i++) {
			System.out.printf("%-" + getMaxLengthOfWords(s) + "s", s.get(i));
			System.out.printf("%" + (getMaxLengthOfNumber(a) + 1) + "d", a.get(i));
			System.out.printf("%" + (getMaxLengthOfNumber(b) + 1) + "d", b.get(i));
			System.out.printf("%" + (getMaxLengthOfNumber(a, b) + 5) + ".3f\n", (double) a.get(i)/ (double) b.get(i));
		}
	}
}
