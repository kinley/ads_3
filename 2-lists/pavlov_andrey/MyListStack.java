package DZ;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MyListStack {
	
	private class Node{
		String item;
		Node next;
	}
	
	
	private Node head;
	private int N;
	
	public void push(String item)
	{
		Node p = new Node();
		p.item = item;
		p.next = head;
		head = p;
		N++;
	}
	
	public String pop()
	{
		String p = head.item;
		head = head.next;
		N--;
		return p;
	}
	
	public int size()
	{
		return N;
	}
	
	
	public boolean isEmpty()
	{
		return N == 0;
	}
	
	public Node previous(Node p){
		Node q=head;
		while(q.next!=p)
			q=q.next;
		return q;
	}
	
	public void DeleteWordZ(){
		Node p=head;
		while(p!=null){
			if(p.item.charAt(0)=='z'||p.item.charAt(0)=='Z'){
				if(p==head){
					head=p.next;
					p.next=null;
					p=head;
				}
				else{
				Node q=previous(p);
				q.next=p.next;
				p.next=null;
				p=q.next;
				}
			}
			else
			p=p.next;
	
		}
		
		
	}
	
	public static MyListStack CreateListStackString(FileReader FR) throws IOException{
			BufferedReader bRf = new BufferedReader(FR);
			MyListStack stack=new MyListStack();
			String str=bRf.readLine();
			while(str!=null){
				stack.push(str);
				str=bRf.readLine();
			}
			return stack;
	}
	
	public void Show(){
		Node p=head;
		while(p!=null){
			System.out.print(p.item+" ");
			p=p.next;
		}
		System.out.println();
	}
	
	
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileReader FR = new FileReader("Text.txt");
		MyListStack stack = new MyListStack();
		stack = CreateListStackString(FR);
		System.out.println("Start list:");
		stack.Show();
		stack.DeleteWordZ();
		System.out.println("Rezult list after operation:");
		stack.Show();
		
	}

}