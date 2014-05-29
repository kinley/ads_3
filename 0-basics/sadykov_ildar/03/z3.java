
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class z3 {

public static void main(String[] args)
{
	String path="input.txt";
	File f = new File(path);
	Scanner in = null;
	try {
		in = new Scanner(f);
	} catch (FileNotFoundException e) {		
		e.printStackTrace();
	}
	String s; int a, b; double c;
	while (in.hasNext())
	{
	s=in.next();
	a=in.nextInt();
	b=in.nextInt();
	c=0;
	if(b!=0) c=(double)a/b;
	System.out.printf("%15s", s);
	System.out.printf("%10d",a);
	System.out.printf("%10d", b);
	System.out.printf("%10.3f", c);
	System.out.printf("%n");
	}
	}	
}
