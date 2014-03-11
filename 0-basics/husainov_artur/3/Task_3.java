package pkg0zadanie;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Task_3 {
    private static void Show_table_from_file(File file){
	Scanner in;
        try {
                in = new Scanner(new FileReader(file));                    
                while(in.hasNext()){
                    String s = in.next();
                    int n1 = in.nextInt();
                    int n2 = in.nextInt();
                    System.out.printf("%-10s %10d %10d %10.3f\n", s, n1, n2, (float)n1/n2);
                }
                in.close();
            } 
            catch (FileNotFoundException ex) {
                Logger.getLogger(Task_3.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    public static void main(String[] args){
	File file = new File("src/input.txt");
        Show_table_from_file(file);
    }
}
