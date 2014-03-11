package pkg0zadanie;

import java.util.Scanner;

public class Task_2 {
    public static void main(String[] args) {
        System.out.print("Введите строку: ");
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        System.out.println(" -Эта строка палиндором?");
        System.out.println(" -" + (new Word(s)).isPalindrom());
        in.close();
    }
}
class Word{
    String Word;
    Word(String Word){
        this.Word=Word;
    }
    String isPalindrom()
    {
        boolean a=true;
        int n=Word.length();
        for(int i=0;a&&i<=n/2;i++)
        if(!(Word.charAt(i)==Word.charAt(n-1-i))) a=false;
        if(a) return "Да";
        else return "Нет";
    }
}
