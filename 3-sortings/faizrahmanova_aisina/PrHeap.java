import java.io.FileNotFoundException; 
import java.io.FileReader;
import java.util.Scanner; 

public class PrHeap {
	
	private int N=0;
	private int[] a;
	
	public PrHeap(int size)
	{
		a=new int[size+1];
		N=size;
	}
	
	private void exch(int i, int j) 
	{
		int t=a[i];
		a[i]=a[j];
		a[j]=t;
	}
	
	private void swim(int k)
	{
		while(k>1 && less(k/2, k))
		{
			exch(k/2, k);
			k=k/2;
		}
		
	}
	
	private boolean less(int i, int j)
	{
		if(a[i]<a[j]) return true;
		else return false;
		//это вместо return a[i].compareTo(a[j])<0;
	}
	
	private void sink(int k)
	{
		while(2*k <= N)
		{
			int j=2*k;
			if(j<N && less(j, j+1)) j++;
			if(!less(k, j)) break;
			exch(k, j);
			k=j;
		}
	}
	
	private void insert(int element, int j)
	{
		a[j]=element;
		swim(j);
	} 
	
	private int delMax()
	{
		int max=a[1];
		exch(1, N); 
		//т.к. у меня не impl.Comparable, то ругается a[N+1]=null;
		N--;
		sink(1);
		return max;
	}
	
	private void show()
	{
		int i=1;
		while(i<a.length)
		{
			System.out.println(a[i]);
			i++;
		}
		
	}
	
	public static void sort(int[] a)
	{
		int N=a.length-1;
		for(int k=N/2; k>=1; k--)
			sink(a, k, N);
		while(N>1)
		{
			//exch(N, 1);
			int t=a[1];
			a[1]=a[N];
			a[N]=t;
			N--;
			sink(a, 1, N);
		}

	}
	
	
	
	private static void sink(int[] a, int i, int N)
	{
		int left=2*i;
		int right=2*i+1;
		int largest=0;
		
		//if(left<N && a[i].compareTo(a[left])<0)
		if(left<N && a[i]>/*< по возрастанию*/a[left])	
		largest=left;
		else largest=i;
		
		//if(right<N && a[largest].compareTo(a[right])<0)
		if(right<N && a[largest]>/*< по возрастанию*/a[right])  
			largest=right;
		
		if(largest != i)
		{
			//exch(i, largest);
			int t=a[i];
			a[i]=a[largest];
			a[largest]=t;
			sink(a, largest, N);
		}
		
		
		
	}
	
	
	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner sc=new Scanner(new FileReader("src/1Mints.txt"));
		PrHeap MyHeap=new PrHeap(1000001);//8001
		int b=0;
		for(int i=1; i<1000001; i++)//8001
		{
			int j=i+1;
			b=sc.nextInt();
			MyHeap.insert(b, j);
			          
		}
		System.out.println("РАБОТА ЗАВЕРШЕНА");
		
		sc.close();
		
		//int t=MyHeap.delMax();
		//System.out.println("max="+t);

		
		
		sort(MyHeap.a);
		System.out.println("sorted");
		MyHeap.show();
		
		
		
	}


	
}
