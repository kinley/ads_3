import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;


public class MergeSort  {
	
	public static void merge(int []a, int lo, int mid1, int mid2, int hi){
		
		int i = lo, j = mid1, k = mid2;
		
		for (int s=lo; s<=hi; s++)
			aux[s] = a[s]; 
			
		for (int s=lo; s<=hi; s++)
		{
			if (i >= mid1) 
			{
				if (j < mid2){
					if (k <= hi)
					{
						if (aux[j] < aux[k])
							  a[s] = aux[j++];
						else  
							  a[s] = aux[k++];
					}
					else a[s] = aux[j++];
					}
				else a[s] = aux[k++];
			}
		
			
			else if (j >= mid2)
			{
				if (k <= hi)
				{
					if (aux[i] < aux[k]) 
							  a[s] = aux[i++];
					else  
							  a[s] = aux[k++];
				}
				else a[s] = aux[i++];
			}
			
			
			else if (k > hi)
			{
				if (aux[i] < aux[j]) 
						a[s] = aux[i++];
				else   
						a[s] = aux[j++];
			}
			
			
			
			else if(aux[i] < aux[j])
			{
				if (aux[k] < aux[i]) 
						 a[s] = aux[k++];
				else 
						 a[s] = aux[i++];
			}
			
			
			else if(aux[i] > aux[j])
			{
				if (aux[k] < aux[j]) 
						 a[s] = aux[k++];
				else 
						 a[s] = aux[j++];
			}
			
			
			else if (aux[k] < aux[j]) 
					a[s] = aux[k++];			
			
			
			else if (aux[j] < aux[k]) 
					a[s] = aux[j++];
		}
	}
	
	public static int[] aux;
	
	public static void sort (int[] a)
	{
		int n = a.length;
		aux = new int[n];
		int sz=1;;
		int lo=0;
		
		for(sz = 1; sz < n; sz = 3*sz)
			{
			for(lo = 0; lo < n-sz-sz; lo += 3*sz)
				{
				merge(a, lo, lo+sz, lo+sz+sz, Math.min(lo+sz+sz+sz-1, n-1));
				
//				for(int i=0; i < n; i++)
//					StdOut.print(a[i] + " ");
//				StdOut.println();
				}
			
			merge(a,lo,lo+sz, lo+sz, n-1);
//			for(int i=0; i < n; i++)
//				StdOut.print(a[i] + " ");
//			StdOut.println();
			}
		}
	
	
	public static void main(String[] args) throws IOException
	{
		Scanner sc=new Scanner(new FileReader("src/int8.txt"));
		int[] a=new int[8000];
		
		for (int i = 0; i < a.length; i++)	
			a[i] = sc.nextInt();
		sc.close();
		
		sort(a);
		
		Out out = new Out("src/output.txt");
		for(int i=0; i < a.length; i++)
			out.println(a[i] + " ");
		
		StdOut.print("sorted");
	}
}



