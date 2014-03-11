import java.util.Scanner;
public class Triangle {
	public double x1,y1,x2,y2,x3,y3;

	Triangle(double x1,double y1,double x2,double y2,double x3,double y3){
		this.x1=x1;
		this.y1=y1;
		this.x2=x2;
		this.y2=y2;
		this.x3=x3;
		this.y3=y3;
	}

	double side12(){ //сторона x1y1<->x2y2
		return Math.sqrt((this.x1-this.x2)*(this.x1-this.x2)+(this.y1-this.y2)*(this.y1-this.y2));
	}

	double side13(){
		return Math.sqrt((this.x1-this.x3)*(this.x1-this.x3)+(this.y1-this.y3)*(this.y1-this.y3));
	}

	double side23(){
		return Math.sqrt((this.x2-this.x3)*(this.x2-this.x3)+(this.y2-this.y3)*(this.y2-this.y3));
	}

	double angle1_rad(){ //угол при вершине х1,y1
		return Math.asin(2*square()/(side12()*side13()));
	}

	double angle2_rad(){
		return Math.asin(2*square()/(side12()*side23()));
	}

	double angle3_rad(){
		return Math.asin(2*square()/(side13()*side23()));
	}

	double angle1_degree(){
		return Math.toDegrees(angle1_rad());//или *180/Math.PI;
	}

	double angle2_degree(){
		return Math.toDegrees(angle2_rad());
	}

	double angle3_degree(){
		return Math.toDegrees(angle1_rad());
	}


	double perimeter(){
		return side12()+side13()+side23();
	}

	double square(){ //площадь треуголника
		double p=perimeter()/2.0;
		return Math.sqrt(p*(p-side12())*(p-side13())*(p-side23()));
	}

	void shift(double x, double y){ //сдвиг
		this.x1+=x;
		this.x2+=x;
		this.x3+=x;
		this.y1+=y;
		this.y2+=y;
		this.y3+=y;

	}

	void turn(double rad){ //поворот вокруг (0,0)
		double nc=Math.cos(rad);
		nc = (  (double)Math.round(nc * 100000000000L)  ) / 100000000000L;
		double ns=Math.sin(rad);
		ns = (  (double)Math.round(ns * 100000000000L)  ) / 100000000000L;

		double x=this.x1;
		double y=this.y1;
		this.x1=x*nc-y*ns;
		this.y1=x*ns+y*nc;

		x=this.x2;
		y=this.y2;
		this.x2=x*nc-y*ns;
		this.y2=x*ns+y*nc;

		x=this.x3;
		y=this.y3;
		this.x3=x*nc-y*ns;
		this.y3=x*ns+y*nc;


	}

	void show_Tr(){
		System.out.println("("+this.x1+","+this.y1+") ("+this.x2+","+this.y2+") ("+this.x3+","+this.y3+")");
	}

	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		double n1=sc.nextDouble();
		double n2=sc.nextDouble();
		double n3=sc.nextDouble();
		double n4=sc.nextDouble();
		double n5=sc.nextDouble();
		double n6=sc.nextDouble();
		sc.close();

		//например, 1 0 1 3 5 0

		Triangle Tr=new Triangle(n1,n2,n3,n4,n5,n6);

		System.out.println(Tr.side13());
		System.out.printf("%.1f\n",Tr.perimeter());
		System.out.printf("%.2f\n",Tr.square());

		Tr.show_Tr();
		System.out.println(Tr.angle1_degree());

		Tr.turn(Math.PI/2);
		Tr.show_Tr();

	}

}
