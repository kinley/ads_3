package mma4;

import java.util.LinkedList;
import java.util.Scanner;


public class Josephus {//задача Иосифа
		
	public static void josephus(LinkedList list, int n, int m){ 
		int i=0;
		
		while (list.size()!=1){
			i = (i+m)%n;
			System.out.print(list.get(i) + " ");
			list.remove(i);
			n--;
		}
		
		System.out.println();
		System.out.println("win number = " + list.getFirst().toString());
	}
	
	public static void create(LinkedList list, int n){
		for (int i=0;i<n;i++)
			list.add(i);	
	}
	
	
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Vvedite kolichestvo elementov: ");
		int n = sc.nextInt();
		System.out.println("Vvedite shag: ");
		int m = sc.nextInt();
		
		create(list, n);
		josephus(list, n, m);
	}
}

