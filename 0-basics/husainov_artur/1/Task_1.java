package pkg0zadanie;

import java.util.Scanner;

public class Task_1 {
    public static void main(String[] args) {
        System.out.print("Введите кол-во строк и столбцов через пробел: ");
        Scanner in = new Scanner(System.in);
	int A = in.nextInt();
        int B = in.nextInt();
        Bool_array a=new Bool_array(A,B);
        a.Draw();
    }
}
class Bool_array{    
    private int line;
    private int collumn;
    private Boolean a[][]; 
    Bool_array(int line_number,int collumn_number){
        line=line_number;
        collumn=collumn_number;
        a= new Boolean [line][collumn];
        for(int i=0;i<line;i++)
        for(int j=0;j<collumn;j++)
        if(j%4==0||i%2==0) a[i][j]=true;
        else a[i][j]=false;
    }
    public void Draw()
    {
        for(int i=0;i<line;i++)
        {
            for(int j=0;j<collumn;j++)
            if(a[i][j]) System.out.print("*");
            else System.out.print(" "); 
            System.out.println();
        }
    }
}
