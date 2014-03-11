package pkg0zadanie;

import java.util.Scanner;
public class Task_4 {
    private static int NOD(int A, int B){
        System.out.printf("A = %-10d B = %d \n", A, B);
	if (B == 0) return A;
        int C = A % B;
        return NOD(B, C);
	}
    public static void main(String[] args){
            System.out.print("Введите кол-во A и B через пробел: ");
            Scanner in = new Scanner(System.in);
            int A = in.nextInt();
            int B = in.nextInt();
            System.out.println("Ответ: NOD=" + NOD(A,B));
   }
}
