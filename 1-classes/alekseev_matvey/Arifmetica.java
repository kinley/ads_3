import java.util.Scanner;

public class Arifmetica {
private int[] mas=new int[101];

public static Arifmetica plus(Arifmetica a,Arifmetica b)
{
	int[] result=new int[102];
	for (int i=0;i<101;i++)
		{
			result[i+1]=(a.mas[i]+b.mas[i]+result[i])/10;
			result[i]=(a.mas[i]+b.mas[i]+result[i])%10;
		}
	Arifmetica res=new Arifmetica();
	for (int i=0;i<101;i++)
		res.mas[i]=result[i];
	return res;		
}

public static Arifmetica minus(Arifmetica a,Arifmetica b)
{
	int[] result=new int[101];
	for (int i=0;i<101;i++)
		{
			if ((a.mas[i]-b.mas[i])>=0)
			{
				result[i]=a.mas[i]-b.mas[i];
			}
			else
			{
				result[i]=(a.mas[i]-b.mas[i]+10)%10;
				a.mas[i+1]=a.mas[i+1]-1;
			}
		}
	Arifmetica res=new Arifmetica();
	for (int i=0;i<101;i++)
		res.mas[i]=result[i];
	return res;		
}


public static Arifmetica multiplication(Arifmetica a,Arifmetica b)
{
	int s=0,m=0;
	Arifmetica res=new Arifmetica();
	for (int i=0;i<50;i++)
	{
		Arifmetica res1=new Arifmetica();
		for (int j=0;j<50;j++)
		{			
			s=(a.mas[i]*b.mas[j])+s/10;
			res1.mas[j+m]=s%10+res1.mas[j+m];					
		}		
		s=0;
		m++;
		res=plus(res,res1);
		for (int x=0;x<101;x++) res1.mas[x]=0;
	}
	return res;		
}


public Arifmetica(){}

public Arifmetica(int a)
{
	int i=0;
	while (a>0)
		{
			mas[i]=a%10;
			a=a/10;
			i++;
		}
	
}

public Arifmetica(int a, int b)
{
	
	Arifmetica k=new Arifmetica(a);
	Arifmetica n=new Arifmetica(32768);
	Arifmetica r=new Arifmetica();
	r=multiplication(k,n);
	Arifmetica g=new Arifmetica(b);
	r=plus(g,r);
	for (int i=0;i<101;i++)
		mas[i]=r.mas[i];
	
}

public static void sravnenie(Arifmetica a,Arifmetica b)
{
	boolean bool=true;
	for (int i=0;i<101;i++)
		if (!(a.mas[i]==b.mas[i])) bool=false;
	if (bool==true)
		{
			a.show();
			System.out.print("=");
			b.show();
			System.out.println();
		}
	else
		{
			a.show();
			System.out.print("!=");
			b.show();
			System.out.println();
		}
				
}

public void show()
{
	boolean k=false;
	for (int i=0;i<101;i++)
	{
		if (!(mas[100-i]==0)&&k==false) k=true;
		if (k==true)System.out.print(mas[100-i]);
	}
}

	public static void main(String[] args)
	{
		int a,b;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter first number Y");
		a=sc.nextInt();
		System.out.println("Enter second number X (2^15>X>0)");
		b=sc.nextInt();
		Arifmetica ar=new Arifmetica(a,b);
		Arifmetica ar1=new Arifmetica();
		System.out.print("Y*(2^15)+X=");
		ar.show();
		System.out.println();
		
		ar1=plus(ar,ar);
		ar.show();
		System.out.print("+");
		ar.show();
		System.out.print("=");
		ar1.show();
		System.out.println();
		
		ar1.show();
		ar1=minus(ar1,ar);
		System.out.print("-");
		ar.show();
		System.out.print("=");
		ar1.show();
		System.out.println();
		
		
		ar.show();
		System.out.print("*");
		ar.show();
		System.out.print("=");
		ar1=multiplication(ar,ar);
		ar1.show();
		System.out.println();
		
		sravnenie(ar,ar);
		sravnenie(ar,ar1);
		
		
		
		
	}

}
