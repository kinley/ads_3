import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashSet;



public class Dictionary {
	
	private LinkedHashSet<String>[] rankingTable;
	private int size;
	
	Dictionary()
	{
		size = 0;
		rankingTable = new LinkedHashSet[2];
		createLists();
	}
	
	private void createLists()
	{
		for(int i = 0; i < rankingTable.length; i++)
			rankingTable[i] = new LinkedHashSet<String>();
	}
	
	public boolean isMember(String item)
	{
		return rankingTable[hashFunction(item)].contains(item);
	}
	
	private boolean isOverflowed()
	{
		return size >= rankingTable.length;
	}
	
	private void extention()
	{
		
		LinkedHashSet<String> allItems = new LinkedHashSet<String>();
		
		for(int i = 0; i < rankingTable.length; i++)
		{
			allItems.addAll(rankingTable[i]);
		}

		rankingTable = new LinkedHashSet[rankingTable.length*2];
		createLists();
		
		for(String item : allItems)
		{
			insert(item);
		}
	}
	
	public void insert(String item)
	{
		if(isOverflowed())
		{
			extention();
			rankingTable[hashFunction(item)].add(item);
		}
		else
		{
			rankingTable[hashFunction(item)].add(item);
		}
		
		size ++;
	}
	
	public int size()
	{
		return size;
	}
	
	private int hashFunction(String str)
	{		
		int sum = 0;
		
		for(int i = 0; i < str.length(); i++)
		{
			sum += (int)str.charAt(i) -'0';
		}
		
		return sum % rankingTable.length;
	}
	
	public boolean delete(String item)
	{
		if(rankingTable[hashFunction(item)].remove(item))
		{
			size --;
			return true;
		}
		else return false;
	}
	
	public String toString()
	{
		String str = "";
		
		for(int i = 0 ; i < rankingTable.length; i++)
		{
			for(String item: rankingTable[i])
			{
				str += item  + "  " +  "\n";
			}
		}
		
		return str;
	}
	
	public String toListsString()
	{
		String str = "";
		
		for(int i = 0 ; i < rankingTable.length; i++)
		{
			str += rankingTable[i].toString() + "\n";
		}
		
		return str;
	}
	
	
	public static void main(String[] args) throws IOException
	{
		
		
	}
	
	Dictionary(String fileName) throws IOException
	{
		size = 0;
		rankingTable = new LinkedHashSet[2];
		createLists();
		
		BufferedReader fileIn = new BufferedReader(new FileReader(fileName));
	    String str = new String();
	    
	    
	    while ((str = fileIn.readLine()) != null) 
	    {
	    	insert(str);
	    }	
	    fileIn.close();
	}
	
}
