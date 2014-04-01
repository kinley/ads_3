
public class DoubleLinkedList<Item> 
{

	private  class Node
	{
		Item item;
		Node next;
		Node previous;
	}
	
	private Node head;
	private Node end;
	private int nodeCount;
	
	
	

	
	public Item getItemByIndex(int index)
	{
		return this.getNodeByIndex(index).item;
	}
	
	public int size()
	{
		return nodeCount;
	}
	
	private Node getNodeByIndex(int index)
	{
		if(index > nodeCount)
			return null;
		else
		{
			Node p = head;
			for(int i = 0; i < index; i++)
			{
				p = p.next;
			}
			return p;
		}
		
	}
	
	
	
	public void add(Item item)
	{
		Node p = new Node();
		p.item = item;
		
		if(nodeCount == 0)
		{
			p.next = null;
			p.previous = null;
			head = p;
			end = p;
		}
		else
		{
			p.next = null;
			p.previous = end;
			end.next = p;
			end = p;
		}
		nodeCount ++;
	}
	
	
	public boolean addBefore(int index,Item item)
	{
		if(index > nodeCount)
			return false;
		else
		{
			this.addBfr(this.getNodeByIndex(index), item);
			return true;
		}
	}
	public boolean addAfter(int index,Item item)
	{
		if(index > nodeCount)
			return false;
		else
		{
			this.addAft(this.getNodeByIndex(index), item);
			return true;
		}
	}
	
	public Item pop()
	{
		Item item = head.item;
		head = head.next;
		head.previous = null;
		nodeCount --;
		return item;
	}
	
	public Item deleteItemByIndex(int index)
	{
		if (index > nodeCount)
		{
			return null;
		}
		else
		{
			Node p = head;
			for(int i=0; i < index; i++)
			{
				p = p.next;	
			}
			
			if(p == head)
			{
				head = head.next;
				nodeCount --;
				return p.item;
			}
			if(p == end)
			{
				Node q = p.previous;
				q.next = null;
				end = q;
				nodeCount --;
				return p.item;
			}
			
			Node q = p.previous;
			q.next = p.next;
			nodeCount --;
			return p.item;	
		}
	}
	
	private void addBfr(Node before,Item item)
	{
		Node p = new Node();
		p.item = item;
		nodeCount ++;
		if (before==head)
		{			
			p.next = head;
			p.previous = null;
			head = p;
			
		}
		else
		{
			p.next = before;
			p.previous = before.previous;
			before.previous.next = p;
			before.previous = p;
		}
	}
	private void addAft(Node after,Item item)
	{
		Node p = new Node();
		p.item = item;
		nodeCount ++;

		if (after==end)
		{			
			p.next = null;
			p.previous = end;
			end = p;
		}
		else
		{
			p.next = after.next;
			p.previous = after;
			after.next.previous = p;
			after.next = p;
		}
	}
	
	public String toString()
	{
		String str = "";
		Node p = head;
		for(int i = 0; i < nodeCount; i++ )
		{
			str += "[ " + p.item.toString() + " ]";
			p = p.next;
		}
		return str;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(10);
		
		System.out.println(list);
		
		list.addBefore(4, 9);
		list.addAfter(3, 5);
		System.out.println(list);
		
		System.out.println(list.getItemByIndex(list.size()-1));
		
	}

}
