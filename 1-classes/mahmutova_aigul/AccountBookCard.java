package task_1_19;
import java.util.Scanner;
public class AccountBookCard {
	String author;
	String title;
	int publication_date;
	int id;
	double cost;
	public AccountBookCard(String auther, String title, int publication_date, int[] id, double cost) {
		this.author = auther;
		this.title = title;
		this.publication_date = publication_date;
		this.id = id[0];
		this.cost = cost;
		id[0]++;
	}
	public AccountBookCard(AccountBookCard copyCard, int[] id) {
		author = copyCard.author;
		title = copyCard.title;
		publication_date = copyCard.publication_date;
		this.id = id[0];
		cost = copyCard.cost;
		id[0]++;
	}
	public double getCost() {
		return cost;
	}
	public boolean checkPublicationDate(int n) {
		if (publication_date < n) return true;
		return false;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public static void enterDetails(Scanner in, String[] auther, String[] title, int[] publication_date, double[] cost) {
		System.out.print("Автор книги: ");
		auther[0] = in.next();
		System.out.print("Низвание книги: ");
		title[0] = in.next();
		System.out.print("Год издания книги: ");
		publication_date[0] = in.nextInt();
		System.out.print("Стоимость книги: ");
		if (in.hasNextInt()) cost[0] = (double) in.nextInt();
		else cost[0] = in.nextDouble();
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
		String[] auther = new String[1]; 
		String[] title = new String[1];
		int[] publication_date = new int[1];
		int[] id = new int[1];
		id[0] = 1;
		double[] cost = new double[1];
		System.out.println("Карточка1:");
		enterDetails(in, auther, title, publication_date, cost);
		AccountBookCard card1 = new AccountBookCard(auther[0], title[0], publication_date[0], id, cost[0]);
		System.out.println("Карточка1:");
		card1.showAccountBookCard();
		System.out.println("Карточка2:");
		enterDetails(in, auther, title, publication_date, cost);
		AccountBookCard card2 = new AccountBookCard(auther[0], title[0], publication_date[0], id, cost[0]);
		System.out.println("Карточка2:");
		card2.showAccountBookCard();
		AccountBookCard card3 = new AccountBookCard(card1, id);
		System.out.println("Карточка3:");
		card3.showAccountBookCard();
		if (card2.checkPublicationDate(2000)) card2.setCost(2*card2.getCost());
		System.out.println(card2.cost);
		System.out.println("Измененная карточка2:");
		card2.showAccountBookCard();
		in.close();
	}
}

