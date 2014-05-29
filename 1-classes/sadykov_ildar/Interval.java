/* #4 Классы (Интервальная арифметика).
Интервальное число – [a,b]={x/x?R, a<=x<=b}, где R – поле вещественных чисел. Операции:
  [a,b]+[c,d]=[a+c,b+d];
  [a,b]-[c,d]= [a-c,b-d];
  [a,b]*[c,d]=[MIN(ac,ad,bc,bd),MAX(ac,ad,bc,bd)];
  [a,b]/[c,d]=[a,b]*[1/d,1/c], где 0I[c,d].
Методы класса - создать число, вычислить «границы» (a,b), «размах» (b-a), операции +-/*
*/


public class Interval {
	private double a,b;
	
	Interval(double x, double y)
	{
		a=x;
		b=y;
	}
	
	Interval()
	{
		a=0;
		b=0;
	}
	
	double MIN(double q, double w, double e, double r)
	{
		double min = q;
		if(w<min) min=w;
		if(e<min) min=e;
		if(r<min) min=r;		
		return min;
	}
	
	double MAX(double q, double w, double e, double r)
	{
		double max = q;
		if(w>max) max=w;
		if(e>max) max=e;
		if(r>max) max=r;		
		return max;		
	}
	
	Interval add (Interval x)
	{
		Interval z=new Interval(x.a+a, x.b+b);
		return z;		
	}
	
	Interval minus (Interval x)
	{
		double t1=a-x.a;
		double t2=b-x.b;
		double temp;
		if(t1>t2) //для того, чтобы [1,-1] отображалось как [-1,1]
			{
			temp=t1; 
			t1=t2; 
			t2=temp; 
			}
		Interval z=new Interval(t1, t2);
		return z;		
	}
	
	Interval mult (Interval x)
	{
		Interval z=new Interval(MIN(a*x.a,a*x.b,b*x.a, b*x.b), MAX(a*x.a,a*x.b,b*x.a, b*x.b));
		return z;
	}
	
	Interval div (Interval x)
	{
		Interval z=new Interval();
		if(x.a==0||x.b==0) 
			{
			System.out.print("Divide by zero!");
			z.a=0; z.b=0;
			return z;
			}
				
		Interval t=new Interval(1/x.a, 1/x.b);
		z=mult(t);
		return z;				
	}
	
	double size()
	{
		if(b<a) return 0;
		return b-a;
	}		
	
	void Show()
	{
		System.out.println("[" + a + "," + b + "]");
	}
	
	public static void main(String[] args)
	{
		Interval a=new Interval(-6,8);
		Interval b=new Interval(-2,4);
		Interval z=new Interval();
		
		System.out.print("a=");
		a.Show();
		System.out.print("b=");
		b.Show();
		
		System.out.print("size of a = ");
		System.out.println(a.size());
		System.out.print("size of b = ");
		System.out.println(b.size());
		
		System.out.print("a+b=");
		z=a.add(b);
		z.Show();
		
		System.out.print("a-b=");
		z=a.minus(b);
		z.Show();
		
		System.out.print("a*b=");	
		z=a.mult(b);
		z.Show();
		
		System.out.print("a/b=");
		z=a.div(b);
		z.Show();		
	}
}
