import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class PrArray {
	private int N=8000;
	private int[] a=new int[N];
	
	PrArray()
	{
		for(int i=0; i<N; i++)
			a[i]=0;
	}
	
	
	private void exch(int i, int j)
	{
		int t=a[i];
		a[i]=a[j];
		a[j]=t;
	}
	

	private void insert(int element, int j)
	{
		a[j]=element;
		while(j!=0 && a[j]>=a[j-1])
		{
			exch(j, j-1);
			j--;
		}

	}
	
	private int delMax()
	{
		int t=a[0];
		for(int i=0; i<N-1; i++)
			a[i]=a[i+1];
		//a[N-1]=(Integer) null;
		N--;
		return t;
	}
	
	
	private void show()
	{
		int i=0;
		while(i<N)
		{
			System.out.println(a[i]);
			i++;
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner sc=new Scanner(new FileReader("src/8Kints.txt"));
		PrArray MyArray=new PrArray();
		
		int b=0;	
		int i=0;
		while(i<8000)
		{
			int j=i;
			b=sc.nextInt();
			MyArray.insert(b,j);
			i++;
			
		}	
		sc.close();
		
		System.out.println("Работа Закончена");
		
		
		
		//MyArray.show(); 
		//System.out.println("все");
		
		/*int t=MyArray.delMax();
		System.out.println(t);
		System.out.println();
		
		MyArray.show();*/
		
		
	}

}
