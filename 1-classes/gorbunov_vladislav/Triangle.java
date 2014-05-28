package apa;

import java.util.Scanner;

class Triangle {
    public double r1, a1, r2, a2, r3, a3;

    Triangle(double r1, double a1, double r2, double a2, double r3, double a3) {
        this.r1 = r1;
        this.a1 = a1;
        this.r2 = r2;
        this.a2 = a2;
        this.r3 = r3;
        this.a3 = a3;
    }

    double side(double r1, double a1, double r2, double a2) {
        return Math.sqrt(r1 * r1 + r2 * r2 - 2 * r1 * r2 * Math.cos(a1 - a2));
    }

    double side12() {
        return side(r1, a1, r2, a2);
    }

    double side13() {
        return side(r1, a1, r3, a3);
    }

    double side23() {
        return side(r2, a2, r3, a3);
    }

    double angle1_rad() {
        return a1;
    }

    double angle2_rad() {
        return a2;
    }

    double angle3_rad() {
        return a3;
    }

    double angle1_degree() {
        return Math.toDegrees(angle1_rad());
    }

    double angle2_degree() {
        return Math.toDegrees(angle2_rad());
    }

    double angle3_degree() {
        return Math.toDegrees(angle1_rad());
    }


    double perimeter() {
        return side12() + side13() + side23();
    }

    double square() {
        double p = perimeter() / 2.0;
        return Math.sqrt(p * (p - side12()) * (p - side13()) * (p - side23()));
    }

    void shift(double x, double y) {
        double rx1 = r1 * Math.cos(a1) + x;
        double ry1 = r1 * Math.sin(a1) + y;
        r1 = Math.sqrt(rx1 * rx1 + ry1 * ry1);
        a1 = Math.acos(rx1 / r1);

        double rx2 = r2 * Math.cos(a2) + x;
        double ry2 = r2 * Math.sin(a2) + y;
        r2 = Math.sqrt(rx2 * rx2 + ry2 * ry2);
        a2 = Math.acos(rx2 / r2);

        double rx3 = r3 * Math.cos(a3) + x;
        double ry3 = r3 * Math.sin(a3) + y;
        r3 = Math.sqrt(rx3 * rx3 + ry3 * ry3);
        a3 = Math.acos(rx3 / r3);
    }

    void turn(double rad) {
        a1 += rad;
        a2 += rad;
        a3 += rad;
    }

    void show_Tr() {
        System.out.println("(" + this.r1 + "," + this.a1 + ") (" + this.r2 + "," + this.a2 + ") (" + this.r3 + "," + this.a3 + ")");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double n1 = sc.nextDouble();
        double n2 = sc.nextDouble();
        double n3 = sc.nextDouble();
        double n4 = sc.nextDouble();
        double n5 = sc.nextDouble();
        double n6 = sc.nextDouble();
        sc.close();


        Triangle Tr = new Triangle(n1, n2, n3, n4, n5, n6);

        System.out.println(Tr.side13());
        System.out.printf("%.1f\n", Tr.perimeter());
        System.out.printf("%.2f\n", Tr.square());

        Tr.show_Tr();
        System.out.println(Tr.angle1_degree());

        Tr.turn(Math.PI / 2);
        Tr.show_Tr();

    }
}