import java.io.FileNotFoundException;   
import java.io.FileReader;
import java.util.Scanner;

public class PrQueue {
	
	private class Node
	{
		Node next;
		int element;
	}
	
	private Node head;
	private Node tail;
	
	PrQueue()
			{
				head=tail=null;
			}
	
	private boolean isEmpty()
	{
		return head==null;
	}
	
	private void insert(int elem)
	{
		if(isEmpty())
		{
			head=new Node();
			head.element=elem;
			head.next=null;
			tail=head;
		}
		else
		{			
			if(elem>=head.element)
			{
				Node p=new Node();
				p.element=elem;
				p.next=head;
				head=p;
			}
			else
			{
				Node p=head;
				while(p.next!=null && p.next.element>=elem)
				   p=p.next;
				
				Node q=new Node();
				q.element=elem;
				q.next=p.next;
				p.next=q;
			}
			
		}
	}
	
	private int delMax()
	{
		int t=head.element;
		head=head.next;
		return t;
	}
	
	private void show()
	{
		Node p=this.head;
		while(p!=null)
		{
			System.out.println(p.element);
			p=p.next;
		}
		
	}
	
	
	public static void main(String[] args) throws FileNotFoundException
	{
		PrQueue MyQueue=new PrQueue();
		Scanner sc=new Scanner(new FileReader("src/8Kints.txt"));
		int b=0;
		for(int i=0; i<8000; i++)
		{
			b=sc.nextInt();
			MyQueue.insert(b);	
			//MyQueue.show();
			
		}
		sc.close();
		System.out.println("Работа закончена");		
		
		
		//MyQueue.show();
		
		/*System.out.println("все");
		int t=MyQueue.delMax();
		System.out.println("Максимальный элемент:"+t);
		System.out.println();
		MyQueue.show();*/
		
	}

}


