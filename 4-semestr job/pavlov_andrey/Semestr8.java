/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package semestr8;

import java.io.File;
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
        
        File file = new File("input.txt");
    	Scanner in;
        in = new Scanner(file);
        int sz=in.nextInt();
        PQueue T=new PQueue(in);
        System.out.println(T.size());
        System.out.println(sz);
        while(!T.empty()){
        
        System.out.println(T.min());
        T.removeMin();
        }
        LinkedList result;
        result=MST(T,sz);
        out(result);
    }

    private static LinkedList MST(PQueue T, int size) throws Exception {
        LinkedList result = new LinkedList();
        HashSet set=new HashSet();
        int i=0;
        while(i<size-1){
             System.out.println(T.min());
            Edge min=(Edge) T.min();
            System.out.println(min);
            T.removeMin();
            if(!set.contains(min.getV())||!set.contains(min.getW())){
                set.add(min.getV());
                i++;
                result.add(min);
            }
        }
        return result;
    }

    private static void out(LinkedList result) {
         while(!result.isEmpty())
        System.out.print(result.peek()+" ");
    }
    
   
    
}
