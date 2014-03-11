package zadanien22;

import java.util.Scanner;

public class Bank {  //класс Банк, конечно, можно еще разрабатывать, но это уже другая история
    static void transfer(CashAccount From,CashAccount To, double cash){
        if(From.isCashMoreThan(cash)) 
        {
            To.deposit(cash);
            From.withdraw(cash);
        }
        else System.out.println("!!!Недостаточно денег на счёте N"+From.ID()+"!!!");
    }
    public static void main(String[] args) {
        CashAccount N1=new CashAccount(1,"Husainov Artur Almazovich");
        System.out.print("Введите сумму которую вы хотите положить на счёт N1: ");
        Scanner in=new Scanner(System.in);
        int s1=in.nextInt();
        N1.deposit(s1);
        CashAccount N2=new CashAccount(2,"Tarasov Vladislav Alekseevich");
        transfer(N1,N2, 100);
        CashAccount N3=new CashAccount(3,N2);
        transfer(N3,N1, N3.cash()/2);
        N1.showInfo();
        N2.showInfo();
        N3.showInfo();
    }
}
class CashAccount{
    private int ID;
    private String FIO;
    private double cash;
    CashAccount(int ID,String FIO){
        this.ID=ID;
        this.FIO=FIO;
        this.cash=0;
    }
    CashAccount(int ID,CashAccount OldAcc){
        this.ID=ID;
        this.FIO=OldAcc.FIO;
        this.cash=OldAcc.cash();
        OldAcc.withdraw(OldAcc.cash());
    }
    public void deposit(double a){
        cash=cash+a;
    }
    public void withdraw(double a){
        cash=cash-a;
    }
    public double cash(){
        return cash;
    }
    public boolean isCashMoreThan(double a){
        return (cash>=a);
    }
    ///Самодеятельность
    public void showInfo(){
        System.out.printf("%-30s %10d %10.3f\n",FIO,ID,cash);
    }
    public int ID(){
        return ID;
    }
    
}