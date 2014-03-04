package zadanie0;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class Z03 {
	private static void read(File file) throws FileNotFoundException{
		Scanner in = new Scanner(new FileReader(file));
		while(in.hasNext()){
		String s = in.next();
		int n1 = in.nextInt();
		int n2 = in.nextInt();
		System.out.printf("%-14s %d %10d %12.3f\n", s, n1, n2, (float)n1/n2);
		}
		in.close();
	}
	
	public static void main(String[] args) throws UnsupportedEncodingException, FileNotFoundException{
		File file = new File("src/input.txt");//надо файл в папку src закинуть
		read(file);
	}
}
