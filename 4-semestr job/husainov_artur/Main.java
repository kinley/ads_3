import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class Main{
 	
    public static void report(String legislator, Dictionary goodguys, Dictionary badguys)
    {
        if(goodguys.contains(legislator)) System.out.println(legislator + " - это друг");
            else 
            {
                if (badguys.contains(legislator)) System.out.println(legislator + " - это враг");
                else System.out.println("Нет данных о "+legislator);
            }
    }

    public static void favor(String legislator, Dictionary goodguys , Dictionary badguys)
    {
        goodguys.insert(legislator);
        badguys.delete(legislator);
    }
        
    public static void unfavor(String legislator, Dictionary goodguys , Dictionary badguys)
    {
        badguys.insert(legislator);
        goodguys.delete(legislator);
    }
	
    public static void main(String[] args) throws IOException 
    {		
        BufferedReader fileIn=new BufferedReader(new InputStreamReader(new FileInputStream("input.txt"),"windows-1251"));
        String str;
        Dictionary goodguys=new Dictionary();
        Dictionary badguys=new Dictionary();
        goodguys.loadFromFile("Good.txt");
        badguys.loadFromFile("Bad.txt");
        str=fileIn.readLine();
        while(str!=null&&!str.equals(""))
        {
            String[] line=str.split(" ");
            String legislator=line[0];
            String command=line[1];		
            if(command.equals("F")) favor(legislator, goodguys, badguys);
            if(command.equals("U")) unfavor(legislator, goodguys, badguys);
            if(command.equals("?")) report(legislator, goodguys, badguys);
            str=fileIn.readLine();
        }
        goodguys.saveToFile("outGood.txt");
        badguys.saveToFile("outBad.txt");
    }
}
