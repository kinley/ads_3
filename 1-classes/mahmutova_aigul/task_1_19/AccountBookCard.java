package task_1_19;
import java.util.Scanner;
public class AccountBookCard {
	String author;
	String title;
	int publication_date;
	int id;
	double cost;
	public AccountBookCard(String a, String t, int d, int k, double c) {
		author = a;
		title = t;
		publication_date = d;
		id = k;
		cost = c;
	}
	public double getCost() {
		return cost;
	}
	public boolean checkPublicationDate(int n) {
		if (publication_date < n) return true;
		return false;
	}
	public void setCost(double c) {
		cost = c;
	}
	public void copyAccountBookCard(AccountBookCard a) {
		author = a.author;
		title = a.title;
		publication_date = a.publication_date;
		cost = a.cost;
	}
	public static void enterDetails(Scanner in, String[] a, String[] t, int[] d, double[] c) {
		System.out.print("Автор книги: ");
		a[0] = in.next();
		System.out.print("Низвание книги: ");
		t[0] = in.next();
		System.out.print("Год издания книги: ");
		d[0] = in.nextInt();
		System.out.print("Стоимость книги: ");
		if (in.hasNextInt()) c[0] = (double) in.nextInt();
		else c[0] = in.nextDouble();
	}
	public void showAccountBookCard() {
		System.out.println("Автор книги: " + author);
		System.out.println("Низвание книги: " + title);
		System.out.println("Год издания книги: " + publication_date);
		System.out.println("Код книги: " + id);
		System.out.println("Стоимость книги: " + cost);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int k=1;
		String[] a = new String[1]; 
		String[] t = new String[1];
		int[] d = new int[1];
		double[] c = new double[1];
		System.out.println("Карточка1:");
		enterDetails(in, a, t, d, c);
		AccountBookCard b1 = new AccountBookCard(a[0], t[0], d[0], k, c[0]);
		k++;
		System.out.println("Карточка1:");
		b1.showAccountBookCard();
		System.out.println("Карточка2:");
		enterDetails(in, a, t, d, c);
		AccountBookCard b2 = new AccountBookCard(a[0], t[0], d[0], k, c[0]);
		k++;
		System.out.println("Карточка2:");
		b2.showAccountBookCard();
		AccountBookCard b3 = new AccountBookCard("", "", 0, k, 0.0);
		k++;
		b3.copyAccountBookCard(b1);
		System.out.println("Карточка3:");
		b3.showAccountBookCard();
		if (b2.checkPublicationDate(2000)) b2.setCost(2*b2.getCost());
		System.out.println(b2.cost);
		System.out.println("Измененная карточка2:");
		b2.showAccountBookCard();
		in.close();
	}
}

