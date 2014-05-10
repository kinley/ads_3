import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class SocietyForTheProtectionOfTuna {
	
	

	
	public static void saveDictionary(String fileName,Dictionary guys) throws IOException
	{
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
		out.flush();
		out.println(guys);
		out.close();
	}
	
	public static void report(String legislator, Dictionary goodguys, Dictionary badguys)
	{
		if(goodguys.isMember(legislator))
			System.out.println(legislator + " - friend");
		else if (badguys.isMember(legislator))
			System.out.println(legislator + " - foe");
		else
			System.out.println("Not found");
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
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader fileIn = new BufferedReader(new FileReader("input.txt"));

		
		String str;
		Dictionary goodguys = new Dictionary("good.txt");
		Dictionary badguys = new Dictionary("bad.txt");
		
		
		
		str = fileIn.readLine();
	
		while( str != null && !str.equals(""))
		{
			String[] commandAndName = str.split("\\ ");
			String legislator = commandAndName[0];
			String command = commandAndName[1];
			
			if(command.equals("+"))
				favor(legislator, goodguys, badguys);
			
			
			if (command.equals("-"))
				unfavor(legislator, goodguys, badguys);
			
			
			if (command.equals("?"))
				report(legislator, goodguys, badguys);
			
		
			str = fileIn.readLine();
		}
		
		saveDictionary("outGood.txt",goodguys);
		saveDictionary("outBad.txt",badguys);
	
	}
}