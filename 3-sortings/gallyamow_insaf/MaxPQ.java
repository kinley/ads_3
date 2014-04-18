
import java.util.*;


public class MaxPQ<Key extends Comparable<Key>> {
	
	
	public class MyList<Key> extends LinkedList<Key>
	{
		
		public Key pop(Key max)
		{
			return this.remove(this.indexOf(max));
		}
		
		
	}
	
	
	
	private MyList<Key> list;
	private Key max;
	private int size;
	
	
	MaxPQ()
	{
		size = 0;
		max = null;
		list = new MyList<Key>();
	}
	
	MaxPQ(Key keys[])
	{	
		size = 0;
		max = null;
		list = new MyList<Key>();
		
		for(int i = 0 ; i < keys.length; i++)
		{
			this.insert(keys[i]);
		}
	}
	
	
	
	
	public Key max()
	{
		if(size == 0)
		{
			return null;
		}
		else
		{
			Key maximum = list.getFirst();
			for(Key p: list)
			{
				if(p.compareTo(maximum) == 1)
					maximum = p;
			}
			return maximum;
		}
	}
	
	
	
	
	public void insert(Key key)
	{
		
		list.push(key);
		size ++;
		max = this.max();
	}
	
	public Key delMax()
	{	
		Key qurrentMax = list.pop(max);
		size --;
		max = this.max();
		return qurrentMax;
	}
	
	
	public int size()
	{
		return size;
	}
	
	public boolean isEmpty()
	{
		return size == 0;
	}

	public static void main(String[] args) {
		
		
		MaxPQ<Integer> pq = new MaxPQ<Integer>();
		LinkedList<Integer> items = new LinkedList<Integer>();	
		Random rnd = new Random();
		
	
		for(int i = 0; i < 100; i++)
		{
			pq.insert(rnd.nextInt(50));
		}
		
		for(int i = 0; i < 200; i++)
		{
			pq.insert(rnd.nextInt(50));
			if(pq.size() > 150)
				items.add(pq.delMax());
		}
		
		while(!pq.isEmpty())
		{
			items.add(pq.delMax());
		}
		
		
		
		
		
		
		System.out.println(items);
		System.out.println(items.size());
	}

}
