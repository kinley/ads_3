import java.util.LinkedList;
import java.util.List;


public class Liest {

	
public static int max(LinkedList<Integer> a)
{
	int max=a.get(0);
	int i=0;
	while (i<a.size())
	{
		if (a.get(i)>max)
			max=a.get(i);
		i++;		
	}
	return max;
}
public static void recursivMax(LinkedList<Integer> a,int max)
{	
	
	int max1 = max;	
	if (a.size()==0)
		{
		System.out.print("max=");
		System.out.println(max1);
		}
	while (a.size()>0)
	{
		if (max1<a.getFirst()) max1=a.getFirst();
		int k=a.remove(0);
		recursivMax(a,max1);
	}
}

	public static void main(String[] args) 
	{
		LinkedList<Integer> list=new LinkedList<Integer>();
		list.add(10);
		list.add(7);
		list.add(48);			
		list.add(495);	
		list.add(482);	
		System.out.println(max(list));
		recursivMax(list,list.getFirst());

	}

}
