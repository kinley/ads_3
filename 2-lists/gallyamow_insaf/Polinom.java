

import java.util.*;


	
	public class Polinom  
	{
		public class Item
		{
			int pow;
			double coef;
			
			Item()
			{
				
			}
			
			public String toString()
			{
				if(pow == 1)
					return  coef + "*x";
				else
				{
				if(pow == 0)
					return coef + "";
				else
					return coef + "*x" + pow;
				} 
				
			}
		}
		
		private class Node
		{
			Item item = new Item(); 
			Node next;
		}
		
		private Node head;
		private Node end;
		private int elementsCount;

		
		
		Polinom()
		{
			head = null;
			elementsCount = 0;
			end = null;
		}
		
		public Node getHead()
		{
			return head;
		}
		
		public void show()
		{
			Node p = head;
			System.out.print(p.item);
			p = p.next;
			for(int i = 1; i < elementsCount; i++)
			{
				if(p.item.coef > 0)
					System.out.print(" +" + p.item);
				else
					System.out.print(" " + p.item);
				p = p.next;
			}
		}
		
		public boolean isEmpty()
		{
			return elementsCount == 0;
		}
		
		public int size()
		{
			return elementsCount;
		}
		
		public void add(double coef,int pow)
		{
			
			
			Node p = new Node();
			p.item.coef = coef;
			p.item.pow = pow;
			
			if(head == null)
			{
				p.next = null;
				head = p;
				end = p;
			}
			else
			{
				p.next = null;
				end.next = p;
				end = p;
			}
			
			elementsCount ++;
		}
		
		public Item pop()
		{
			Item p = head.item;
			head = head.next;
			elementsCount --;
			return p;
		}
		
		public void scalarMult(double scalar)
		{
			Node p = head;
			for(int i=0; i < elementsCount; i++)
			{
				p.item.coef = scalar * p.item.coef;
				p = p.next;
			}
		}
		
		
		
		
		
		public void monomMult(Item x)
		{
			Node p = head;
			for(int i=0; i < elementsCount; i++)
			{
				p.item.coef = x.coef * p.item.coef;
				p.item.pow += x.pow;
				p = p.next;
			}
		}
		
		public void refresh()
		{
			Node p = head;
			Node q = p;
			int size = elementsCount;
			for(int i=0; i < size; i++)
			{
				if(p.item.coef == 0)
				{
					if(p == head)
					{
						elementsCount --;
						head = head.next;
					}
					else
					{
						elementsCount --;
						q.next = p.next;
					}
				}
				q = p;
				p = p.next;
			}
		}
		public void addMonom(Item item)
		{
			Node p = head;
			for(int i=0; i<elementsCount;i++)
			{
				if(p.item.pow == item.pow)
				{
					p.item.coef += item.coef;
					return;
				}
				p = p.next;
			}
			
			add(item.coef,item.pow);
			this.refresh();
		}
		
		public void sumPolinoms(Polinom a)
		{
			Node p = a.getHead();
			for(int i=0;i<a.size();i++)
			{
				this.addMonom(p.item);
				p = p.next;
			}
			
		}
		
		public Polinom copyPolinom()
		{
			Polinom copy = new Polinom();
			Node p = head;
			for(int i=0; i < elementsCount; i++)
			{
				copy.add(p.item.coef, p.item.pow);
				p = p.next;
			}
			return copy;
		}
		
		public void multLinePolinom(double scalar,Item x)
		{
			Polinom copy = this.copyPolinom();
			copy.scalarMult(scalar);
			this.monomMult(x);
			this.sumPolinoms(copy);
			this.refresh();
		}
		
		


	public static void main(String[] args) 
	{
		Polinom poli = new Polinom();
		
		for(int i = 0; i < 5; i++)
		{
			poli.add(1, i);
		}
		
		Polinom a = new Polinom();
		a.add(-2, 1);		
		
		poli.multLinePolinom(2,a.pop());
		
		poli.show();
		
	}
		
}


