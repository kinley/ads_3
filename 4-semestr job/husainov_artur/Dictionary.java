
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

class Node{
    
    public String item;
    public Node[] next;

    public Node(int level, String value) 
    {
        next=new Node[level + 1];
        this.item=value;
    }
}

public class Dictionary{
    
    private static double P=0.5;
    private static int MAX_LEVEL=6;
    private final Node head;
    private int level;
    
    Dictionary() throws IOException
    {
	head=new Node(MAX_LEVEL, null);
	level=0;
    }
    
    public void loadFromFile(String fileName) throws IOException
    {
        BufferedReader fileIn=new BufferedReader(new InputStreamReader(new FileInputStream(fileName),"windows-1251"));
	String str=new String();    
	while((str=fileIn.readLine())!=null) 
	{
            insert(str);
	}	
	fileIn.close();
    }
    
    public static int randomLevel() 
    {
        int lvl=(int)(Math.log(1.-Math.random())/Math.log(1.-P));
        return Math.min(lvl, MAX_LEVEL);
    } 
 
    public boolean contains(String searchValue)
    {
        Node x=head;
        for(int i=level;i>=0;i--) 
        {
	    while(x.next[i]!= null&&x.next[i].item.compareTo(searchValue)<0) 
            {
	        x=x.next[i];
	    }
	}
	x=x.next[0];
        return x!=null&&x.item.equals(searchValue);
    }
    
    public void insert(String value)
    {
        Node x=head;	
        Node[] update=new Node[MAX_LEVEL+1];
        for(int i=level;i>=0;i--) 
        {
	    while(x.next[i]!=null&&x.next[i].item.compareTo(value)<0) 
            {
	        x=x.next[i];
	    }
	    update[i]=x; 
	}
	x=x.next[0];
        if(x==null||!x.item.equals(value)) 
        {        
            int lvl=randomLevel();
            if(lvl>level) 
            {
	        for(int i=level+1;i<=lvl;i++) 
                {
	            update[i]=head;
	        }
	        level=lvl;
	    }
            x=new Node(lvl, value);
	    for(int i=0;i<=lvl;i++) 
            {
	        x.next[i]=update[i].next[i];
	        update[i].next[i]=x;
	    }
        }
    }

    public void delete(String value)
    {
        Node x=head;	
        Node[] update=new Node[MAX_LEVEL + 1];
        for(int i=level;i>=0;i--) 
        {
	    while(x.next[i]!=null&&x.next[i].item.compareTo(value)<0) 
            {
	        x=x.next[i];
	    }
	    update[i]=x; 
	}
	x=x.next[0];
        if(x!=null)
        if(x.item.equals(value)) 
        {
            for(int i=0;i<=level;i++) 
            {
	        if(update[i].next[i]!= x) break;
	        update[i].next[i]=x.next[i];
	    }
            while(level>0&&head.next[level]==null) 
            {
	        level--;
	    }
        }
    }
    
    public void saveToFile(String fileName) throws IOException
    {
        PrintWriter out=new PrintWriter(new OutputStreamWriter(new FileOutputStream(fileName),"windows-1251"));
        out.flush();
        Node x=head.next[0];
        while(x!=null) 
        {
            out.println(x.item);
            x=x.next[0];
        }
        out.close();
    }
}
