
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Queue {
	private class Node{
		char item;
		int exp;
		Node next;
	}
	
	private Node head;
	private Node tail;
	int n;
	
	Queue(){
		head=tail=null;
	}
	
	private void add(char item, int a){//добавление в конец
		if(head==null){
			head=new Node();
			head.item=item;
			head.exp=a;
			head.next=null;
			tail=head;
			
		}
		else{
			Node p=new Node();
			p.item=item;
			p.exp=a;		
			tail.next=p;
			p.next=null;
			tail=p;
		}
	}
	
	private void show(){
		Node p=head;
		while(p!=null){
			System.out.print(p.item);
			p=p.next;
		}
	}

	private void copy(Queue queue){
		Node p=queue.head;
		while(p!=null){
			add(p.item, p.exp);
			p=p.next;
		}
	}
	
	private void sum(Queue queue1, Queue queue2){
		
		Node p1=queue1.head;
		Node p2=queue2.head;
		
		while(p1!=null&&p2!=null){
			if(p1.exp==p2.exp){	
				this.add('0', p1.exp);
				p1=p1.next;
				p2=p2.next;
				}
			else if(p1.exp>p2.exp){//в очереди степени расположены в порядке убывания
				this.add(p1.item, p1.exp);
				p1=p1.next;
			}
			else if(p2.exp>p1.exp){
				this.add(p2.item, p2.exp);
				p2=p2.next;
			}
			
			
		}
		if(p1==null&&p2!=null){
			queue2.head=p2;
			this.copy(queue2);
			
		}
		if(p2==null&&p1!=null){
			queue1.head=p1;
			this.copy(queue1);
			
		}
		
		
	}
	
	
	public static void main(String[] args) throws FileNotFoundException{
		Scanner sc=new Scanner(new FileReader("src/in.txt"));
		int a=sc.nextInt();
		int b=sc.nextInt();
		sc.close();
		System.out.println("Первое число:"+a);
		System.out.println("Второе число:"+b);
		
		String s1=Integer.toBinaryString(a);
		System.out.println("Первое(в двоичной системе):"+s1);
		
		String s2=Integer.toBinaryString(b);
		System.out.println("Второе(в двоичной системе):"+s2);
		
		Queue queue1=new Queue();
		Queue queue2=new Queue();
		Queue queue3=new Queue();
		
		int k=s1.length();
		int i=0;
		while(i<k){
			if(s1.charAt(i)=='1')
				queue1.add(s1.charAt(i),k-i-1);
			i++;
		}
		
		k=s2.length();
		int j=0;
		while(j<k){
			if(s2.charAt(j)=='1')
				queue2.add(s2.charAt(j),k-j-1);
			j++;
		}
		System.out.print("Первая очередь:");
		queue1.show();
		System.out.println();
		System.out.print("Вторая очередь:");
		queue2.show();
		System.out.println();
		System.out.print("Ответ:");
		queue3.sum(queue1, queue2);
		queue3.show();
		
	
		
		
		
	}

}
