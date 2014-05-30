/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package semestr8;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.HashSet;

/**
 *
 * @author Андрей
 */
public class Semestr8 {

   
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        
        File fileIn = new File("input.txt");
        File fileOut = new File("output.txt");
    	Scanner in;
        in = new Scanner(fileIn);
        int sz=in.nextInt();
        PQueue T=new PQueue(in);
        LinkedList result;
        result=MST(T,sz);
        out(result,fileOut);
        System.out.println("done");
    }

    private static LinkedList MST(PQueue T, int size) throws Exception {
        LinkedList result = new LinkedList();
        HashSet set=new HashSet();
        Edge min;
        min=(Edge) T.min();
        set.add(min.getV());
        set.add(min.getW());
        result.add(T.min());
        T.removeMin();
        int i=1;
        while(i<size-1){
            min=(Edge) T.min();
            T.removeMin();
            if(set.contains(min.getV())){
                if(!set.contains(min.getW())){
                    set.add(min.getW());
                    i++;
                    result.add(min);
                    }
                }
            else
                if(set.contains(min.getW()))
                    if(!set.contains(min.getV())){
                        set.add(min.getV());
                        i++;
                        result.add(min);
                        }
                    
        }
        return result;
    }

    private static void out(LinkedList result, File file) throws IOException {
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file)));
         while(!result.isEmpty()){
            out.print(result.pop()+" ");
            out.flush();
         }
         
    }
    
   
    
}
