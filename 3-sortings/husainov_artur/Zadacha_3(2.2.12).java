package tuikin_4;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Zadacha_3(2.2.12) {

    public static Comparable[] aux;
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Scanner in= new Scanner(new FileReader("src/int1.txt"));
        FileWriter out= new FileWriter("src/output.txt");
        int N=1000;
        int M=50;
        aux=new Integer[2*M]; //разве можно сливая два блока длины M обойтись только М дополнительной памятью
        Integer[] a=new Integer[N];
        for(int i=0;i<N;i++)
            a[i]=in.nextInt();
        in.close();
        sort(a,M);
        merge(a,M);
        show(a,out);
        out.close();
    }

    private static void sort(Comparable[] a,int M){ //сортируем блоки выбором
        int N = a.length;
        int k=0;
        while(k!=N){
            sort(a,k,k+M);
            k=k+M;
        }
    }
            
    private static void sort(Comparable[] a,int start,int end){
        for(int i=start;i<end;i++)
            {
                int min=i;
                for(int j=i+1;j<end;j++)
                    if(less(a[j],a[min])) min=j;
                exch(a,i,min);
            }
    }
    
    private static boolean less(Comparable v, Comparable w)
    {
        return v.compareTo(w)<0;
    }
    
    private static void exch(Comparable[] a,int i,int j){
        Comparable t=a[i];
        a[i]=a[j];
        a[j]=t;
    }
    
    private static void show(Comparable[] a,FileWriter out) throws IOException
    {
        for(int i=0;i<a.length;i++) {
            out.write(""+a[i]+"\n");
        }
    }
        
    private static void merge(Comparable[] a,int M){ //раз задание творчесоке то я придумал "пузырьковое слияние" =)
        int N = a.length;
        int k=0;
        int l=0;
        while(l!=N){
            k=0;
            while(k!=N-M-l){
                merge(a,k,k+M-1,k+2*M-1);
                k=k+M;
            }
            l=l+M;
        }
    }
    private static void merge(Comparable[] a,int lo,int mid,int hi){
        int i=lo,j=mid+1;
        for(int k=lo;k<=hi;k++)
            aux[k-lo]=a[k];
        for(int k=lo;k<=hi;k++)
            if     (i>mid)                a[k]=aux[j++-lo];
            else if(j>hi)                 a[k]=aux[i++-lo];
            else if(less(aux[j-lo],aux[i-lo]))  a[k]=aux[j++-lo];
            else                          a[k]=aux[i++-lo];
    }

}
