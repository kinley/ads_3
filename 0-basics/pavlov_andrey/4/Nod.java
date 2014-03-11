import java.util.Scanner;

public class Nod {
	private static Scanner input;

	static int CalcNod(int x, int y){
		while (x!=0&&y!=0)
			if(x>y)
				x=x%y;
			else
				y=y%x;
		
		return x+y;
		}
	
	public static void main(String []arg){
		System.out.println("Введите первое число");
		input = new Scanner(System.in);
		String str=input.next();
		int x=Integer.parseInt(str);
		System.out.println("Введите второе число");
		str=input.next();
		int y=Integer.parseInt(str);
		System.out.println("НОД:"+CalcNod(x,y));
		
	}
}


