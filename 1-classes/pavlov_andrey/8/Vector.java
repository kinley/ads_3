package DZ;

public class Vector {
	private double a;
	private double b;
	
	
	double getFirstCoor(){
		return a;
	}
	
	double getSecondCoor(){
		return b;
	}
	
	double setFirstCoor(double x){
		return a=x;
	}
	
	double setSecondCoor(double x){
		return b=x;
	}
	
	Vector(){
		this.a=1;
		this.b=1;
	}
	
	Vector(double a, double b){
		this.a=a;
		this.b=b;
	}
	
	Vector plus(Vector y){
		Vector c=new Vector();
		c.setFirstCoor(a+y.a);
		c.setSecondCoor(b+y.b);
		return c;
	}
	
	Vector minus(Vector y){
		Vector c=new Vector();
		c.setFirstCoor(a+(-1)*y.a);
		c.setSecondCoor(b+(-1)*y.b);
		return c;
	}
	
	double Scalar_multiplication(Vector y){
		return a*y.a+b*y.b;
	}
	
	Vector Mult_to_scalar(double x){
		Vector c=new Vector();
		c.setFirstCoor(x*this.a);
		c.setSecondCoor(x*this.b);
		return c;
	}
			
	public static void main(String[] args){
	}
	
}

