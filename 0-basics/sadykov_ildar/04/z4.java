

import java.util.Scanner;

public class z4{
	
	public static int NOD(int a, int b)
    {
    	
		while (b !=0) {
            int tmp = a%b;
            a = b;
            System.out.print("p=" + a);
            b = tmp;
            System.out.println(", q=" + b);
        }
        return a;
    }
	
	public static void main(String[] args)  
	{
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		int b = in.nextInt();
		in.close();
		System.out.println();
		System.out.println("Nod=" + NOD(a,b));
		
	}
}

