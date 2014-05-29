class node<Item>
{
	Item data;
	node next;
}


public class Queue_Ring<Item> 
{
	node<Item> last;
	Queue_Ring()
	{
		last=null;
	}
	Queue_Ring(Item item)
	{
		last.data=item;
		last.next=last;
	}
	void push(Item item)
	{
		node<Item> temp=new node<Item>();
		temp.data=item;
		if(last==null)
			{				
				last=temp;
				last.next=last;
			}
		else 
			{
				temp.next=last.next;
				last.next=temp;
			}
	}
	
	Item pop()
	{
		node<Item> prev=new node<Item>();
		node<Item> temp=new node<Item>();
		temp=last;
		if(last==null) 
			{
			System.out.println("Queue is empty!");
			return null;
			}
		else 
			if(last.next==last)	last=null;
			else
			{			
				prev=last;
				while(prev.next!=last) 
					prev=prev.next;
				prev.next=last.next;
				last=prev;	
			}		
		return (Item) temp.data;
	}
	
	boolean isEmpty()
	{
		if(last==null) return true; else return false;
	}
	
	void show()
	{
		node<Item> temp=new node<Item>();		
		if(isEmpty())
			System.out.println("Queue is empty");
		else
			{
			temp=last.next;
			if(last.next==last)
			{
				System.out.println(last.data);
			}
			else
				do
				{
					System.out.println(temp.data);
					temp=temp.next;
				}
				while(temp!=last.next);
			}
			
	}
	
	public static void main(String[] args)
	{
		Queue_Ring<String> q=new Queue_Ring<String>();
		q.show();
		
		q.push("1");
		System.out.println("first push");		q.show();
		
		q.push("2");
		System.out.println("second push");		q.show();
		
		q.push("3");
		System.out.println("third push");		q.show();
		
		q.push("4");
		System.out.println("fourth push");		q.show();
				
		String a;
		
		a=q.pop();		
		System.out.println("first pop"); 		q.show();
		System.out.println("a=" + a);
		
		a=q.pop();		
		System.out.println("second pop"); 		q.show();
		System.out.println("a=" + a);
		
		a=q.pop();		
		System.out.println("third pop"); 		q.show();
		System.out.println("a=" + a);
		
		a=q.pop();
		System.out.println("fourth pop"); 		q.show();
		System.out.println("a=" + a);
	}
	
}
