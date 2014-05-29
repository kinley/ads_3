import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class avtomat {

	int[] S;
	String[] I;
	int[][] d;
	int s0;
	int[] F;
	
	avtomat() {}
	
	avtomat(int[] S, String[] I, int[][] d, int s0,	int[] F)
	{
		copy(this.S,S);
		copy(this.I,I);
		for(int i=0; i<d[0].length; i++)
			copy(this.d[i],d[i]);
		this.s0=s0;
		copy(this.F,F);		
	}
	
	
	public void create(avtomat A)
	{
		Scanner in=new Scanner(System.in);
		
			System.out.println("Enter dimension of S:");
			int n=in.nextInt();
			A.S=new int[n];
			System.out.println("Enter S:");
			for(int i=0; i<n; i++)
				A.S[i]=in.nextInt();
		
			System.out.println("Enter dimension of I:");
			int m=in.nextInt();
			A.I=new String[m];
			System.out.println("Enter I:");
			for(int i=0; i<m; i++)
				A.I[i]=in.next();
			
			A.d=new int[m][];
			for(int i=0; i<m; i++)
				A.d[i]=new int[n];
				
			System.out.println("Enter delta:");
			for(int i=0; i<m; i++)
				for(int j=0; j<n; j++)
					A.d[i][j]=in.nextInt();
			
			System.out.println("Choose s0:");
			A.s0=in.nextInt();
				
			System.out.println("Enter dimension of F:");
			int f=in.nextInt();
			A.F=new int[f];
			System.out.println("Enter F:");
			for(int i=0; i<f; i++)
				A.F[i]=in.nextInt();
			
			in.close();
	}
	
	public static void createFromFile(avtomat A, String path)
	{
		File file=new File(path);
		
		Scanner in = null;
		try {
			in = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int n=in.nextInt();
		A.S=new int[n];
		for(int i=0; i<n; i++)
			A.S[i]=in.nextInt();
	
		int m=in.nextInt();
		A.I=new String[m];
		for(int i=0; i<m; i++)
			A.I[i]=in.next();
		
		A.d=new int[m][];
		for(int i=0; i<m; i++)
			A.d[i]=new int[n];
			
		for(int i=0; i<m; i++)
			for(int j=0; j<n; j++)
				A.d[i][j]=in.nextInt();
		
		A.s0=in.nextInt();
			
		int f=in.nextInt();
		A.F=new int[f];
		for(int i=0; i<f; i++)
			A.F[i]=in.nextInt();
		
		in.close();
	}
	
	public void show()
	{
		int n=S.length, m=I.length;
		
		System.out.println("avtomat:");
		System.out.print("S: ");
		for(int i=0; i<n; i++)
			System.out.print(S[i] + " ");
		
		System.out.println();
		
		System.out.print("I: ");
		for(int i=0; i<m; i++)
			System.out.print(I[i] + " ");
		
		System.out.println();
		
		System.out.println("delta:");
		for(int i=0; i<m; i++)
			{
			for(int j=0; j<n; j++)
				System.out.print(d[i][j] + " ");
			System.out.println();
			}
		System.out.println("s0:" + s0);
		
		System.out.print("F: ");
		for(int i=0; i<F.length; i++)
			System.out.print(F[i] + " ");
		System.out.println();
	}
	
	public void run()
	{
		String input;
		Scanner in=new Scanner(System.in);
		System.out.println("Enter input string:");
		input=in.nextLine();		
		
		int n=input.length();
		int cur_state=s0;
		int k,l;
		for(int i=0; i<n; i++)
		{
			String a=input.charAt(i) + "";
			k=find_input(I, a);
			l=find_state(S, cur_state);
			if(k!=-1 && l!=-1)
			{
				cur_state=d[k][l];				
			}
			else System.out.println("Error!");
		}
		
		if(ExistsInF(cur_state,F)) System.out.println("Строка принадлежит языку");
		else System.out.println("Строка не принадлежит языку");
		
		
	}
	
	
	
	

	////////////////////////////////////
	private void copy(int[] a, int[]b)
	{
		int n=a.length;
		for(int i=0; i<n; i++)
			b[i]=a[i];		
	}
	
	private void copy(String[] a, String[]b)
	{
		int n=a.length;
		for(int i=0; i<n; i++)
			b[i]=a[i];		
	}
	
	private int find_input(String[] i2, String a) {
		
		for(int i=0; i<I.length; i++)
		{
			if(I[i].equals(a)) return i;
		}
		return -1;
	}
	
	private int find_state(int S[], int s)
	{
		int k;
		for(int i=0; i<S.length; i++)
		{
			if(S[i]==s) return i;
		}
		return -1;
		
	}
	
	private boolean ExistsInF(int state, int[] f) 
	{
		for(int i=0; i<f.length; i++)
		{
			if(state==f[i]) return true;
		}
		
		return false;
	}
	////////////////////////////////////
	public static void main(String[] args)
	{
		avtomat M1=new avtomat();
		createFromFile(M1,"B2.txt");		
		M1.show();
		M1.run();
		
	}

}
