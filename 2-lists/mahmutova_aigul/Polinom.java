import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Polinom {
	private class Node {
		int i;
		double a;
		double b;
		Node next;
		Node (int i1, double a1, double b1) {
			i = i1;
			a = a1;
			b = b1;
		}
	}
	private Node first;
	public boolean isEmpty() {
		return first == null;
	}
	public void push(int i1, double a1, double b1) {
		Node p = new Node(i1,a1,b1); 
		p.next = first;
		first = p;
	}
	public void insert(Node p, int i1, double a1, double b1) {
		Node q = new Node(i1,a1,b1); 
		q.next = p.next;
		p.next = q;
	}
	public Node search(int i) {
		Node p = first;
		boolean b = false;
		while (p.next != null && !b) {
			if (p.i < i) p = p.next;
			else b  = true;
		}
		return p;
	}
	public void createPolinom(Scanner in) {
		while (in.hasNextLine()) {
			int i = in.nextInt();
			double a = in.nextDouble();
			double b = in.nextDouble();
			if (a != 0 && b != 0) {
				if (isEmpty()) push(i,a,b);
				else {
					Node p = search(i);
					if (p == first || first == null) push(i,a,b);
					else insert(p,i,a,b);
				}
			}
		}
	}
	public void showPolinom() {
		if (isEmpty()) System.out.println("Polinom is Empty");
		else {
			Node p = first;
			while (p != null) {
				System.out.print(p.i + " " + p.a + " " + p.b + "\n");
				p = p.next;
			}
		}
	}
	public Node previous(Node q) {
		Node p = first;
		boolean b = false;
		while (p != null && !b) {
			if (p.next == q) b = true;
			else p = p.next;
		}
		return p;
	}
	public void cancellation() {
		Node p = first;
		while (p.next != null) {
			Node q = p.next;
			if (p.i == q.i) {
				p.a = p.a+q.a;
				p.b = p.b+q.b;
				if (p.a == 0 || p.b == 0) {
					Node w = previous(p);
					w.next = q.next;
				}
				p.next = q.next;
			}
			else p = p.next;
		}
	}
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		File file = new File("input.txt");
		Polinom m = new Polinom();
		try {
			Scanner in = new Scanner(file);
			m.createPolinom(in);
			m.showPolinom();
			System.out.println("lalala");
			m.cancellation();
			m.showPolinom();
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
