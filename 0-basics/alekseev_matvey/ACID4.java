import java.util.Scanner;


public class ACID4 {

	static int NOD(int a,int b) {
        while (b !=0) {
            int t = a%b;
            System.out.printf("%3d",a);
            System.out.printf("%3d",b);
            System.out.println();
            a = b;
            b = t;            
        }
        return a;
    }
	public static void main(String[] args) 
	{
		int first,second;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter first nimber");
		first=sc.nextInt();
		System.out.println("Enter second nimber");
		second=sc.nextInt();
		int nod=NOD(first,second);
		System.out.print("NOD=");
		System.out.println(nod);
	}

}
