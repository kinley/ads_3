class para
	{
		array s1,s2;
		para next;
		
		para(){}
		para(array i, array j)
		{
			s1=i;
			s2=j;
		}
	}

public class list		//список, куда закидываем пары состояний
{
	para first;
	para last;
	
	public boolean isEmpty()
    {
        return first==null;
    }
	
	public void push(array i, array j)
	{
		para temp=new para(i,j);
		if(first==null) 
        {
            first=temp;
            last=first;            
        }
		 else
	        {
	            if(first==last)
	            {
	                first.next=temp;
	                last=temp;
	            }		            
	            else
	            {
	            	last.next=temp;           	
	            	last=temp;    
	            }
	        }   			
	}
	
	public para pop()
	{
		
		para  prev=new para ();
		para  temp=new para ();
		temp=first;
		if(last==null) 
			{
			System.out.println("Queue is empty!");
			return null;
			}
		else 
			if(first==last)	
				{
					first=null; 
					last=null;
				}
			else
			{			
				prev=temp;
				while(temp!=last) 
					{
						prev=temp;
						temp=temp.next;
					}
				prev.next=null;
				last=prev;	
			}
		
		return temp;
	}
		
	
	public void show()
	{
		para temp=first;
		if(first==null) System.out.println("list is empty");
		while(temp!=null)
		{
			System.out.println(temp.s1.state + " " + temp.s2.state);
			temp=temp.next;
		}
	}
}

