/*
 * pol: top=a[n]->...->a[0]->null 
 * quotient: top=b[0]->...->b[n-1]->null
 * 
 * b=a/(c+d*x)
 * recurrence:  b[n-1]=a[n]/d;
 * 				b[n-2]=a[n-1]-b[n-1]*c/d;
 * 			... b[0]=a[1]-b[1]*c/d;
 * 
 */

public class Task2 {	
		
	public static void main(String[] args) throws CloneNotSupportedException{
		PolynomStack pol=new PolynomStack("coefs.txt");
		PolynomStack polCopy=new PolynomStack();
		polCopy=pol.clone();
		PolynomStack quotient=new PolynomStack();
		
		In in=new In("c&d.txt");
		double c=in.readDouble();
		double d=in.readDouble();
		polCopy.output();
		StdOut.println("/("+c+"+"+d+"x)=");
		int power=polCopy.power();
		double b=polCopy.pop()/d;
		
		for(int i=power;i>0;i--)
		{
			quotient.push(b,i-1);
			power=polCopy.power();
			if (power==i-1) b=(polCopy.pop()-b*c)/d;
			else b=-b*c/d;
		} 
		
		quotient.output();
	}
}


class PolynomStack implements Cloneable {
	private class Node{
		double coef;
		int power;
		Node next;
	}
	
	private Node top;
	private int maxPower;
	
	public PolynomStack(){
		top=null;
		maxPower=0;
	}
	
	public PolynomStack(String fileName){
		top=null;
		maxPower=0;
		In in=new In(fileName);
		
		for(int i=0;!in.isEmpty();i++)
		{
			double a=in.readDouble();
			if(a!=0.0) this.push(a, i);
		} 
	}
	
	public boolean isEmpty(){
		return top==null;
	}
	
	public int power(){
		return maxPower;
		}
	
	public void push(double coef, int pow) {
		Node temp=top;
		top=new Node();
		top.coef=coef;
		top.power=pow;
		top.next=temp;
		if(pow>maxPower) maxPower=pow;
	}
	
	public double pop(){
		if (!this.isEmpty()){
			double popCoef=top.coef;
			top=top.next;
			if(!this.isEmpty()) maxPower=top.power;
			else maxPower=0;
			return popCoef;
		}
		return 0;
	}
	
	
	private Node helpOut(Node temp, int i){
		if(temp.power!=i) StdOut.print("+ 0");
		else 
			{
				if (temp.coef>0) StdOut.print("+");
				StdOut.print(temp.coef + "*x^" + temp.power);
				temp=temp.next;
			}
		StdOut.print(" ");
		return temp;
	}
	
	public void output(){
		if(!this.isEmpty())
		{
			Node temp=this.top;
			if (temp.power<temp.next.power)
				for(int i=0;i<=maxPower;i++)
					temp=helpOut(temp,i);
			else
				for(int i=maxPower;temp!=null;i--)
					temp=helpOut(temp,i);
		
			StdOut.println("\n");
		}
		else StdOut.println("Polynom is empty");
	}
	
	public PolynomStack clone() throws CloneNotSupportedException{
		PolynomStack obj = (PolynomStack) super.clone();
		return obj;
		}	
}