package mma2;

import java.math.*;

public class Triangle { //Треугольник
	private double square;
	private double height;
	private double corner;
	
	Triangle(){
		square = 1;
		height = 1;
		corner = 45;
	}
	
	Triangle(double s, double h, double c){
		square = s;
		height = h;
		corner = c;
	}
	
	Triangle(Triangle triangle, int coef){ //конструктор по подобию
		square = triangle.square * coef * coef;
		height = triangle.height * coef;
	}
	
	Triangle similarity(int coef){ // создание подобного
		Triangle triangle = new Triangle();
		triangle.square = square * coef * coef;
		triangle.height = height * coef;
		return triangle;
	}
	
	double get_square(){
		return square;
	}
	
	double get_height(){
		return height;
	}
	
	double get_corner(){
		return corner;
	}
	
	double[] get_sides(){ 
		double a = 2*square/height; //находим основание S=0/5*a*h
		double b = 2*square/(a*Math.sin(corner/57.3)); //находим сторону S=0.5*a*b*sin(a)
		double a2 = Math.sqrt(b*b - height*height); //находим часть оснвоания (по Т Пифагора)
		double a1 = a - a2; //находим вторую часть основания
		double c = Math.sqrt(height*height + a1*a1); //находим третью сторону (по Т Пифагора)
		double sides[] = {a,b,c};
		return sides;
	}
	
	double[] get_corners(){
		double sides[] = get_sides();
		double a = sides[0];
		double b = sides[1];
		double c = sides[2];
		
		double x = corner;
		double y =( Math.acos((a*a+c*c-b*b)/(2*a*c)))* 57.3; //по Т cos
		double z = 180 - x - y;
		
		double corners[] = {x,y,z};
		return corners;
	}
	
	void show_corners(){
		double corners[] = get_corners();
		System.out.println("alpha = " + corners[0] + '*');
		System.out.println("betta = " + corners[1] + '*');
		System.out.println("gamma = " + corners[2] + '*');
	}
	
	void show_sides(){
		double sides[] = get_sides();
		System.out.println("a = " + sides[0]);
		System.out.println("b = " + sides[1]);
		System.out.println("c = " + sides[2]);
	}
	
	void show(){
		System.out.println("Square = " + square);
		System.out.println("Height = " + height);
		System.out.println("Corner = " + corner + '*');
		this.show_sides();
		this.show_corners();
		
	}
	
	
	

	public static void main(String[] args) {
		Triangle t1 = new Triangle();
		System.out.println("TriangleFirst: ");
		t1.show();
		
		Triangle t2 = new Triangle(0.43,0.86,60);
		System.out.println("TriangleSecond: ");
		t2.show();
		
		Triangle t3 = t1.similarity(2);
		System.out.println("TriangleThird: ");
		t3.show();
	}

}
