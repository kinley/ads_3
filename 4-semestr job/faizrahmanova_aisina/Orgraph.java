
public class Orgraph { 
	
	public int vershina;
	Element first;
	
	public class Element  //элементы списка смежности
	{
		int versh; //вершина графа
		Element next; //указатель на следующий элемент 
		
	};
	
	Orgraph()
	{
		vershina=0;
		first=null;
	}
	Orgraph(int x)
	{
		vershina=x;
		first=null;
	}
	
	public void show()
	{
		System.out.print(vershina+" -> ");
		Element t=first;
		while(t!=null)
		{
			System.out.print(t.versh+"; ");
			t=t.next;
		}
	}
	

	
	public void insert(int b) //вставка элемента списка
	{
		if(first==null)
		{
			first=new Element();
			first.versh=b;
			first.next=null;
		}
		
		else
		{
			Element el=first;
			while(el.next!=null && el.versh<b)
			el=el.next;
			
			Element elem=new Element();
			elem.versh=b;
			elem.next=el.next;
			
			el.next=elem;
		}

	}
	


}
