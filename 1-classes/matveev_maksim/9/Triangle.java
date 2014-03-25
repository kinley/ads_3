package mma2;

import java.math.*;

public class Triangle {
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
		double c = Math.sqrt(height*height - a1*a1); //находим третью сторону (по Т Пифагора)
		double sides[] = {a,b,c};
		return sides;
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
	}
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Triangle t1 = new Triangle();
		t1.show();
		Triangle t2 = new Triangle(3,5,65);
		t2.show();
	}

}
