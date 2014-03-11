import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Table {

	private static BufferedReader bRf;

	public static void main(String []arg) throws IOException{
		String str="\n";
		System.out.printf("%s \t %s \t %s \t %s \n", "Èìÿ", "×1", "×2", "×1/×2");
		FileReader FR = new FileReader("File.txt");
	       bRf = new BufferedReader(FR);
	       do
	        {
	        str=bRf.readLine();
	        if(str!=null){
	        	String []s=str.split(" ");
	        	int x=Integer.parseInt(s[1]);
	        	int y=Integer.parseInt(s[2]);
	        	System.out.printf("%s \t %d \t %d \t %.3f \n", s[0], x, y, (double)x/y);
	        }
	        }
	        while(str!=null);
	}
}
