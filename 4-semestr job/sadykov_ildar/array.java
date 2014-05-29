
public class array		//множества, образующиеся из состояний
{
	int state;
	array next;
	array leader;	//указатель на представителя списка
	array head;		//указатель на начало
	array tail;		//указатель на хвост
	int count;		//число элементов в списке
	public array next_array;
	array(){}
	array(int s)
	{
		state=s;
		count=1;
		head=this;
		leader=this;
		tail=this;
		next=null;
	}
	public void set_state(int s)
	{
		state=s;
	}
	public void show()
	{
		array temp=head;
		while(temp!=null)
		{
			System.out.println("state=" + temp.state);
			System.out.println("count=" + temp.count);
			System.out.println("head=" + temp.head);
			System.out.println("leader=" + temp.leader);
			temp=temp.next;
		}
		
	}
}