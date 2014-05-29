import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class quick 
{
	private static void exch(int[] a, int i, int j)
	{
		int t=a[i];
		a[i]=a[j];
		a[j]=t;		
	}
	
	public static void shuffle(int[] a)
	{
		int n=a.length;
		int i,j;
		for(int k=0; k<n; k++)
		{
			i=(int)(Math.random()*(n-1));
			j=(int)(Math.random()*(n-1));
			exch(a,i,j);
		}
		
	}
	
	private static int partition(int[] a, int lo, int hi)
	{
		int i=lo,j=hi+1;
		int v=a[lo];
		while(true)
		{
			while((a[++i]<v)) if(i==hi) break;
			while(v<a[--j]) if(j==lo) break;
			if(i>=j) break;
			exch(a,i,j);			
		}
		exch(a,lo,j);
		return j;
	}
	
	
	public static void sortShuffle(int[] a)
	{
		shuffle(a);
		sort(a,0,a.length-1);		
	}
	public static void sortWithoutShuffle(int[] a)
	{
		sort(a,0,a.length-1);		
	}
	
	public static void sort(int[] a, int lo, int hi)	
	{
		if(hi<=lo) return;
		int j=partition(a,lo, hi);
		sort(a,lo,j-1);
		sort(a,j+1,hi);		
	}

	
	
	public static void create1(int[] a)
	{
		int n=a.length;
		for(int i=0;i<n;i++)
		{
			a[i]=(int)(Math.random()*10000);
		}
	}
	
	public static void create2(int[] a)
	{
		int n=a.length;
		for(int i=0;i<n/2;i++)
		{
			a[i]=1;
		}
		for(int i=n/2;i<n;i++)
		{
			a[i]=0;
		}
	}
	
	public static void create3(int[] a)
	{
		int n=a.length-1;
		int n2=n/2;
		int n3=n2;
		int count=0;
		
		for(int k=0; k<=n; k++)
		{			
			if(k>n2) 
			{
				n3=n3/2;
				n2=n2+n3+1;
				count++;
			}
			a[k]=count;				
		}
	}
	
	public static void create4(int[] a)
	{
		int n=a.length;
		for(int i=0;i<n/2;i++)
		{
			a[i]=0;
		}
		for(int i=n/2;i<n;i++)
		{
			a[i]=(int)(Math.random()*1000);
		}
	}
	
	public static void create_gauss(int[] a)
	{
		//нормальное распределение - по закону больших чисел
		int n=a.length;
		int[][] b=new int[12][];
		for(int i=0; i<12; i++) b[i]=new int[n];
		
		for(int i=0;i<12;i++)	
			for(int j=0;j<n;j++)
				b[i][j]=(int)(Math.random()*100);

		for(int j=0;j<n;j++)			
			{
				a[j]=b[0][j];
				for(int i=1;i<12;i++)
					a[j]=a[j]+b[i][j];
			}
	}
	
	public static void show(int[] a)
	{
		int n=a.length;
		for(int i=0;i<n;i++)
			System.out.println("i=" + i + ",a[i]=" + a[i]);	
	}
	
	public static void createFromFile(int[] a)
	{
		String path="input.txt";
		Scanner in=null;
		File f=new File(path);
		try {
			in=new Scanner(f);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		int i=0;
		while(in.hasNext())
			{
				a[i]=in.nextInt();
				i++;			
			}		
	}
	
	public static void copy(int[] a, int[]b)
	{
		int n=a.length;
		for(int i=0; i<n; i++)
			b[i]=a[i];		
	}
	
	public static void show_gaussiana(int[] a, int razmernost)
	{
		
		int min=a[0], max=a[0], n=a.length;
		int [] razbienie=new int[razmernost];
		for(int i=0; i<n; i++)
		{
			if(max<a[i]) max=a[i];
			if(min>a[i]) min=a[i];			
		}
		razbienie[0]=min-1;
		razbienie[razmernost-1]=max+1;
		int temp=(max-min)/razmernost;
		for(int i=1; i<razmernost-1; i++)
		{
			razbienie[i]=razbienie[i-1]+temp;
		}
		//show(razbienie);
		int[] rezult=new int[razmernost-1];
		for(int i=0; i<razmernost-1; i++)
			rezult[i]=0;
		for(int i=0; i<n; i++)
			for(int j=0;j<razmernost-1; j++)
				if(razbienie[j]<a[i] && a[i]<=razbienie[j+1]) rezult[j]++;
		//show(rezult);
		for(int i=0; i<razmernost-1; i++)
			{
			for(int j=0; j<rezult[i]; j++)
				System.out.print("*");
			System.out.println();
			}
				
		
	}
	
	public static void main(String[] args)
	{
		int n=1000000;
		int[] a=new int[n];
		int[] b=new int[n];
		
		/*
		 * проверка правильности нормального распределения
		create_gauss(a);
		sortShuffle(a);
		show(a);
		System.out.println();
		show_gaussiana(a,50);
		*/
		
		{
			create1(a);
			copy(a,b);
			System.out.println("All random:");
			long lBegin = System.currentTimeMillis();
			sortShuffle(a);
			long lEnd = System.currentTimeMillis();
			long lDelta = lEnd - lBegin;
			System.out.println("Sorted with shuffle: " + lDelta);
			
			long lBegin1 = System.currentTimeMillis();
			sortWithoutShuffle(b);
			long lEnd1 = System.currentTimeMillis();
			long lDelta1 = lEnd1 - lBegin1;
			System.out.println("Sorted without shuffle: " + lDelta1);
		}
		System.out.println();
		{
			create2(a);
			copy(a,b);
			System.out.println("111...111000...000:");
			long lBegin = System.currentTimeMillis();
			sortShuffle(a);
			long lEnd = System.currentTimeMillis();
			long lDelta = lEnd - lBegin;
			System.out.println("Sorted with shuffle: " + lDelta);
			
			long lBegin1 = System.currentTimeMillis();
			sortWithoutShuffle(b);
			long lEnd1 = System.currentTimeMillis();
			long lDelta1 = lEnd1 - lBegin1;
			System.out.println("Sorted without shuffle: " + lDelta1);
		}
		System.out.println();
		{
			create3(a);
			copy(a,b);
			System.out.println("0000000011112234:");
			long lBegin = System.currentTimeMillis();
			sortShuffle(a);
			long lEnd = System.currentTimeMillis();
			long lDelta = lEnd - lBegin;
			System.out.println("Sorted with shuffle: " + lDelta);
			
			long lBegin1 = System.currentTimeMillis();
			sortWithoutShuffle(b);
			long lEnd1 = System.currentTimeMillis();
			long lDelta1 = lEnd1 - lBegin1;
			System.out.println("Sorted without shuffle: " + lDelta1);
		}
		System.out.println();
		{
			create4(a);
			copy(a,b);
			System.out.println("0..n/2: 0..0, n/2+1..n: random:");
			long lBegin = System.currentTimeMillis();
			sortShuffle(a);
			long lEnd = System.currentTimeMillis();
			long lDelta = lEnd - lBegin;
			System.out.println("Sorted with shuffle: " + lDelta);
			
			long lBegin1 = System.currentTimeMillis();
			sortWithoutShuffle(b);
			long lEnd1 = System.currentTimeMillis();
			long lDelta1 = lEnd1 - lBegin1;
			System.out.println("Sorted without shuffle: " + lDelta1);
		}
		System.out.println();
		{
			create_gauss(a);
			copy(a,b);
			System.out.println("gauss:");
			long lBegin = System.currentTimeMillis();
			sortShuffle(a);
			long lEnd = System.currentTimeMillis();
			long lDelta = lEnd - lBegin;
			System.out.println("Sorted with shuffle: " + lDelta);
			
			long lBegin1 = System.currentTimeMillis();
			sortWithoutShuffle(b);
			long lEnd1 = System.currentTimeMillis();
			long lDelta1 = lEnd1 - lBegin1;
			System.out.println("Sorted without shuffle: " + lDelta1);
		}
		System.out.println();
		
	}	
	
}
