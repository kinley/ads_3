public class structure {		//набор всех состояний

	public array first;
	public array last;
	public array next_array;	//указатель на следующее множество
	public void push(array temp)
	{
		if(first==null)
		{
			first=temp;
			last=first;
		}
		else
		{
			if(first==last)
            {
                first.next_array=temp;
                last=temp;
            }	
			else
            {
            	last.next_array=temp;           	
            	last=temp;    
            }
		}
	}
	
	public void init(int[] S1, int[] S2)
	{
		for(int i=0; i<S1.length; i++)
		{
			array temp=new array(S1[i]);
			push(temp);			
		}
		for(int i=0; i<S2.length; i++)
		{
			array temp=new array(S2[i]);
			push(temp);			
		}
	}
		
		
	public array find(array x) // подразумевается, что x — ссылка на один из элементов
	    {
			return x.leader;
		}

	public void union(array x, array y)
	{   
		x = x.leader;
		y = y.leader;
		if (x == y)
			return;
		else
        if (x.count > y.count)
            swap(x, y);
        array i = x.head;
        while (i != null)
        {
            i.leader = y;
            i = i.next;
        }
        y.tail.next = x.head; // соединили списки
        y.tail = x.tail ;
        y.count += x.count;
	    
	}

	private void swap(array x, array y) {
		array temp=y;
		y=x;
		x=temp;
	}
	
	public array find_state(int s)
	{
		array temp=first;
		while(temp!=null)
		{
			if(temp.state==s) return temp;
			temp=temp.next_array;
		}
		return null;
		
	}
}
