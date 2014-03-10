import java.util.Scanner;
public class Task2 {
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		String s=sc.next();
		int len=s.length();
		char[] a=new char[len];
		int i=0;
		while(i<len){
			a[i]=s.charAt(i);
			i++;
		}
		i=0;
		boolean b=true;
		int j=len-1;
		while(b&&i<j){
			if(a[i]!=a[j])
				b=false;
			i++;
			j--;
		}
		if(b) System.out.println("Palindrom");
		else System.out.println("No");
		
		sc.close();
	}
	

}

