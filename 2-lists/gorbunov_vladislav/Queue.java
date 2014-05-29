package apa;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

class Queue
{

    private static final int q = 3;

    Node head;
    Node tail;

    Queue() 
    {
        head = tail = null;
    }

    public void add(int item, int exp) 
    {
        Node data;
        if (head == null)
        {
            head = new Node();
            tail = head;
            data = head;
        } 
        else 
        {
            tail.next = new Node();
            tail = tail.next;
            data = tail;
        }
        data.item = item;
        data.exp = exp;
    }

    public void show() 
    {
        Node p = head;
        while (p != null)
        {
            System.out.print(p.item);
            p = p.next;
        }
    }

    public void sum(Queue s) 
    { //slozhenie s tekushei
    
    
        Node p1 = head;
        Node p2 = s.head;
        Queue result = new Queue();
        while (p1 != null && p2 != null)
        {
            if (p1 == null) 
            { //esli perviy spisok zakonchen
            	
                while (p2 != null) 
                { //dopisivayem vse iz vtorogo
                	
                    result.add(p2.item, p2.exp);
                    p2 = p2.next;
                }
            } 
            else if (p2 == null) 
            {
            	//esli vtoroi zaconchen
                while (p1 != null) 
                { //dopisivaem vse iz pervogo
                    result.add(p1.item, p1.exp);
                    p1 = p1.next;
                }
            } 
            else if (p1.exp == p2.exp) 
            { // esli ta zhe stepen - to slazhivaem po modulu
                result.add((p1.item + p2.item) % q, p1.exp);
                p1 = p1.next;
                p2 = p2.next;
            } 
            else if (p1.exp > p2.exp) 
            { //inache dobavlayem menshuyou stepen (chtobi ne propusti odinakoviye)
                result.add(p1.item, p1.exp);
                p1 = p1.next;
            } 
            else if (p2.exp > p1.exp) 
            {
                result.add(p2.item, p2.exp);
                p2 = p2.next;
            }
        }
        this.head = result.head; //copiruem
        this.tail = result.tail; //copiruem
    }

    public static void main(String ars[]) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileReader("src/in.txt"));
        int a = sc.nextInt();
        int b = sc.nextInt();
        sc.close();
        System.out.println("a = :" + a);
        System.out.println("b = :" + b);
        System.out.println("q = :" + q);

        String s1 = Integer.toString(a, q);
        System.out.println("a(" + q + "):" + String.format("%15s", s1));

        String s2 = Integer.toString(b, q);
        System.out.println("b(" + q + "):" + String.format("%15s", s2));

        Queue queue1 = new Queue();
        Queue queue2 = new Queue();

        int k = s1.length();
        int i = 0;
        while (i < k) {
            if (s1.charAt(i) != '0')
                queue1.add(s1.charAt(i) - '0', k - i - 1);
            i++;
        }

        k = s2.length();
        int j = 0;
        while (j < k) {
            if (s2.charAt(j) != '0')
                queue2.add(s2.charAt(j) - '0', k - j - 1);
            j++;
        }
        System.out.print("Queue(a):");
        queue1.show();
        System.out.print("\nQueue(b):");
        queue2.show();
        System.out.print("\nSumm:");
        queue1.sum(queue2);
        queue1.show();
    }

    public class Node
    {
        int item;
        int exp;
        Node next;
    }
}
