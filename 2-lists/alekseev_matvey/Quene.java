import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Quene {

public static void read(Queue a)
{
	int n;
	Scanner sc=new Scanner(System.in);
	System.out.println("How much word's you need?");
	n=sc.nextInt();
	System.out.println("Enter your words.");
	for (int i=0;i<n;i++)
	{
		a.add(sc.next());
	}
}

public static void show(Queue a)
{
	Queue b=new LinkedList();
	while (a.peek()!=null)
		b.add(a.poll());
	System.out.println("This your Queue:");
	while (b.peek()!=null)
	{
		String v=new String();
		v=b.poll().toString();
		System.out.print(v);
		System.out.print(" ");
		a.add(v);
	}
	System.out.println();
	
}

public static Queue union(Queue a,Queue b)
{
	Queue c=new LinkedList();
	while (b.peek()!=null&&a.peek()!=null)
		{
			if (b.peek().toString().charAt(0)!='z')
				c.add(b.poll());
			if (a.peek().toString().charAt(0)!='z')
				c.add(a.poll());
		}
	while (a.peek()!=null)
		if (a.peek().toString().charAt(0)!='z')
			c.add(a.poll());
	while (b.peek()!=null)
		if (b.peek().toString().charAt(0)!='z')
			c.add(b.poll());
	return c;		
}

public static void main(String[] args) 
{
	Queue queue=new LinkedList();
	read(queue);
	show(queue);
	Queue queue1=new LinkedList();
	read(queue1);
	show(queue1);
	show(union(queue,queue1));
}
}
