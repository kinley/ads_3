import java.util.Scanner;
import java.io.IOException;

class Polynom{
	private int x_coef;
	private int free_coef;
	
	Polynom()
	{
		x_coef=0;
		free_coef=0;
	}
	
	Polynom (int a, int b)
	{
		x_coef=a;
		free_coef=b;
	}
	
	Polynom Sum(Polynom A, Polynom B, int p)
	{
		x_coef=(A.x_coef+B.x_coef)%p;
		free_coef=(A.free_coef+B.free_coef)%p;
		return this;
	}
	
	Polynom Difference(Polynom A, Polynom B, int p)
	{
		x_coef=(A.x_coef-B.x_coef)%p;
		if (x_coef<0) x_coef+=p;
		
		free_coef=(A.free_coef-B.free_coef)%p;
		if (free_coef<0) free_coef+=p;
		
		return this;
	}
	
	Polynom Multiplication(Polynom A, Polynom B, int p)
	//(ax+b)(cx+d)=acx^2+(ad+bc)x+bd
	//так как задан класс линейных полиномов,
	//умножение переполняет класс.
	//наверно его просто усечь?
	{
		x_coef=(A.x_coef*B.free_coef)%p+(A.free_coef*B.x_coef)%p;
		free_coef=(A.free_coef*B.free_coef)%p;
		return this;
	}
	
	int Power (int a, int pow)//a^pow
	{
		if (pow==1) 
			return a;
		return a*Power(a,pow-1);
	}
	
	int Root(int p) 
	// ax+b=0, x = -b/a = -b * a^(-1)
	// a^(-1) = a^(p-2) mod p
	{
		int a;
		if (p==2)
			a=1;
		else
			a=Power(x_coef,p-2)%p;
		int x=(-free_coef*a)%p+p;
		return x;
	}
	
	boolean isEqual(Polynom A, Polynom B)
	{
		return (A.x_coef==B.x_coef && A.free_coef==B.free_coef);
	}
	
	void show()
	{
		System.out.println(this.x_coef+"x+"+this.free_coef);
	}

}
	
	
public class Task1{
	
	public static boolean isPrime(int n){
		if (n<2) 
			return false;
		for(int i=2;i*i<n;i++)
			if (n%i==0) return false;
		return true;
	}
	
	public static void main(String []args)
	{
		System.out.println("Введите размерность поля p=");
		Scanner sc=new Scanner(System.in);
		int p=sc.nextInt();
		
		if(isPrime(p))
		{
			Polynom P,Q;
			int a,b;
			
			System.out.println("Введите коэффиценты многочлена P");
			a=sc.nextInt();
			b=sc.nextInt();
			
			if (a>=0 && a<p && b>=0 && b<p)
				P = new Polynom(a,b);
			else 
			{
				System.out.println("Коэффиценты должны быть неотрицательными и меньше p");
				return;
			}
			
			System.out.println("Введите коэффиценты многочлена Q");
			a=sc.nextInt();
			b=sc.nextInt();
			sc.close();
			
			if (a>=0 && a<p && b>=0 && b<p)
				Q=new Polynom(a,b);
			else 
			{
				System.out.println("Коэффиценты должны быть неотрицательными и меньше p");
				return;
			}
					
			P.show();
			Q.show();
			Polynom PQ=new Polynom();
			PQ.Sum(P,Q,p);
			PQ.show();
			PQ.Difference(P,Q,p);
			PQ.show();
			PQ.Multiplication(P,Q,p);
			PQ.show();
			int x=PQ.Root(p);
			System.out.println("x="+x);
		}
		else 
		{
			System.out.println("p должно быть простым");
			return;
		}

}

}




