package mma3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ListDz {
	
	public class Node{
		String item;
		Node next;
	
		Node(){
		}
	
		Node(String a){
			item = a;
		}
		
		String get(){
			return item;
		}
	}
	
	
	private Node head;
	private int count;

	ListDz(){
		head = null;
		count = 0;
	}

	
	public static ListDz ñreateList(FileReader file) throws IOException{
		
		BufferedReader buf = new BufferedReader(file);
		ListDz list = new ListDz();
		String str = buf.readLine();
		
		while(str!=null){
			list.add(str);
			str = buf.readLine();
		}
		return list;
	}
	
	
	public void add(String a){
		Node p = new Node(a);
		p.next = head;
		head = p;
		count ++;
	}

	
	public Node previous(Node k){
		if (k==head || count<=1)
			return null;
		else{
			Node p = head;
			Node q = head;
			while(p!=null && p!=k){
				q=p;
				p=p.next;
			}
			
			if (p!=null)
				return q;
			else
				return null;
		}
	}

	
	public void delete(Node k){
		Node q = previous(k);
		q.next = k.next;
		count --;
	}
	
	
	public void show(){
		Node p = head;
		
		while(p!=null){
			System.out.print(p.item + " ");
			p = p.next;
		}
		
		System.out.println();
	}	
	
	
	public void insertBeforeZ(){
		Node p = head;
		while(p.next != null){
			
			if(p.next.item.charAt(0) == 'z'){
				Node q = new Node("; ");
				q.next = p.next;
				p.next = q;
				p = p.next;
			}
			p = p.next;
		}
	}
	
	public void deleteReapeatingNeighbor(){
		Node q = head;
		Node p = q.next;

		while(p!=null){
			if(q.item.equals(p.item))
				delete(q);
			q = q.next;
			p = p.next;
		}
	}
	
	
	public static void main(String[] args) throws IOException{
		FileReader file = new FileReader("vhod.txt");
		ListDz list = new ListDz();
		list = ñreateList(file);
		
		System.out.println("Before:");
		list.show();
		
		list.deleteReapeatingNeighbor();
		list.insertBeforeZ();
		
		System.out.println("After:");
		list.show();
	}
}

