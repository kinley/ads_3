import java.util.Scanner;
public class Task4 {
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int a=sc.nextInt();
		int b=sc.nextInt();
		//a>b
		if(b==0) System.out.println("Error");
		else{
			if(a==0) System.out.println(0);
			else{
				
		int p=a/b, q=a%b;			
		while(q!=0){
			System.out.println("p="+p+"; q="+q);
			a=b;
			b=q;
			p=a/b;
			q=a%b;
			
		}
		if(q==0) System.out.println("p="+p+"; q="+q);
		System.out.println(b);
	}
	}
		sc.close();
	}

}

