import java.util.Random;


public class ACID1 {

	public static void main(String[] args)
	{
		Boolean[][] mas=new Boolean[5][5];
		Random generator = new Random();
		Boolean bool;
		for (int i=0;i<5;i++)
			for (int j=0;j<5;j++)
			{
				bool=generator.nextBoolean();
				mas[i][j]=bool;
			}
		for (int i=0;i<5;i++)
			{	for (int j=0;j<5;j++)
				{
					if (mas[i][j]==true)
						System.out.print("*");
					else 
						System.out.print(" ");
				}
			System.out.println();
			}

	}

}
