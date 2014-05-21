import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Vector;


public class MAIN {
	
	public static void main(String[] args) throws IOException{
		Scanner in1 = new Scanner(new File("input1.txt"));
		Scanner in2 = new Scanner(new File("input2.txt"));
		
		MyTree T1 = new MyTree();
		MyTree T2 = new MyTree();
		
		while (in1.hasNext())
			T1.put(in1.nextInt());
	
		while (in2.hasNext())	
			T2.put(in2.nextInt());
		
		//////////////////////////////////////////
		
		in1 = new Scanner(new File("input11.txt"));
		in2 = new Scanner(new File("input22.txt"));
		
		MyTree T11 = new MyTree();
		MyTree T22 = new MyTree();
		
		while (in1.hasNext())
			T11.put(in1.nextInt());
	
		while (in2.hasNext())	
			T22.put(in2.nextInt());
		
		
		////////////////////////////////////////////
		
		in1 = new Scanner(new File("input111.txt"));
		in2 = new Scanner(new File("input222.txt"));
		
		MyTree T111 = new MyTree();
		MyTree T222 = new MyTree();
		
		while (in1.hasNext())
			T111.put(in1.nextInt());
	
		while (in2.hasNext())	
			T222.put(in2.nextInt());
		
		///////////////////////////////////////////
		
		in1 = new Scanner(new File("input1111.txt"));
		in2 = new Scanner(new File("input2222.txt"));
		
		MyTree T1111 = new MyTree();
		MyTree T2222 = new MyTree();
		
		while (in1.hasNext())
			T1111.put(in1.nextInt());
	
		while (in2.hasNext())	
			T2222.put(in2.nextInt());
		
		in1.close();
		in2.close();
		
		
		
		if(isIsomorf(T1, T2)) System.out.println("T1 & T2: Isomorf\n");
		else System.out.println("T1 & T2: noIsomorf\n");
		
		
		if(isIsomorf(T11, T22)) System.out.println("T11 & T22: Isomorf\n");
		else System.out.println("T11 & T22: noIsomorf\n");
		
		if(isIsomorf(T111, T222)) System.out.println("T111 & T222: Isomorf\n");
		else System.out.println("T111 & T222: noIsomorf\n");
		
		if(isIsomorf(T1111, T2222)) System.out.println("T1111 & T2222: Isomorf\n");
		else System.out.println("T1111 & T2222: noIsomorf\n");
		
	}

	
	
	//////////////////////////////////////////////////////////
	
	private static boolean isIsomorf(MyTree T1, MyTree T2) {
		
		int depth1 = T1.Depth();
		int depth2 = T2.Depth();
		
		
		if(depth1 != depth2)
			return false;
		
		else if(T1.size() != T2.size())
			return false;
		
		else{
		
		T1.writeLevels();
		T2.writeLevels();

		T1.putKeyToLists();
		T2.putKeyToLists();
		
		
		ArrayList<Node> L1 = new ArrayList<Node>();
		ArrayList<Node> L2 = new ArrayList<Node>();
		
		boolean noIsomorf = false;
		
		for (int i = 1; (i < depth1) && (noIsomorf == false); i++){
		//	System.out.println("L1 ");			
		
		L1 = T1.LL(i-1);
		L2 = T2.LL(i-1);
		
		/*	for(int k = 0; k<L1.size(); k++)
			System.out.println("L1 "+ L1.get(k).val);
			
		for(int k = 0; k<L2.size(); k++)
			System.out.println("L2 "+ L2.get(k).val);
		*/	
		
		Vector<int[]> S1 = new Vector<int[]>();
		Vector<int[]> S2 = new Vector<int[]>();
		
		S1 = T1.SetKortezhs(i, L1);
		S2 = T2.SetKortezhs(i, L2);

/*		for(int k = 0; k < S1.size(); k++)
		{for(int j = 0; j < S1.get(k).length; j++)
				System.out.print(S1.get(k)[j]+" ");System.out.println("\n");}
	
		for(int k = 0; k<S2.size(); k++)
		{for(int j = 0; j<S2.get(k).length;j++)
			System.out.print(S2.get(k)[j]+" ");System.out.println("\n\n");}
	*/
		
		sort(S1, 3); 
		sort(S2, 3);
		
	/*	for(int k = 0; k < S1.size(); k++)
		{for(int j = 0; j < S1.get(k).length; j++)
				System.out.print(S1.get(k)[j]+" ");System.out.println("\n");}
	
		for(int k = 0; k<S2.size(); k++)
		{for(int j = 0; j<S2.get(k).length;j++)
			System.out.print(S2.get(k)[j]+" ");System.out.println("\n\n");}
	 */
		
		
		boolean b = false;
		
		if (S1.size() == S2.size())
			for (int k = 0; k<S1.size(); k++)
				if (S1.get(k).length == S2.get(k).length)
					for(int j = 0; j < S1.get(k).length; j++)
						if (S1.get(k)[j] == S2.get(k)[j])
							b = true;
		
		
		if (b == false)
			noIsomorf = true;
		
		else{
			
		T1.putKeyToNotLists(i, S1);		
		T2.putKeyToNotLists(i, S2);


		T1.showKeys();
		T2.showKeys();
		}
		
		}
	

		if(noIsomorf == false)
			return true;
		else return false; 
		
		
		}
		
	}


////////////////////////////////////////////////////
	

	public static void sort(Vector<int[]> A, int m) {
		int i, j, k = 0, sumLen = 0, lmax = 1;
		
		int n = A.size();
		int[] lens = new int [n]; // length of A[i]
		
		for (i = 0; i < n; i++)
			{
				lens[i] = A.get(i).length;
				sumLen += lens[i];
				lmax = Math.max(lens[i], lmax);	// max(A[i].length)
			}
				
		
		int[][] pairs = new int[sumLen][2];	
		int[] l = new int[lmax];		//	number of A[i]: length(A[i]) <= l[j]
	
		for (i = 0; i < n; i++)
			for (j = 1; j <= A.get(i).length; j++)
			{
				pairs[k][0] = j;
				pairs[k][1] = A.get(i)[j-1];
				k++;
				l[j-1]++;
			}
	
		sortFixSize(pairs, sumLen, 2, m);
		
		
		Vector<int[]> noEmpty = new Vector<int[]>();
		k = 0;
		for(i = 0; i < lmax; i++)
		{
			int[] temp = new int[l[i]];
			for(j = 0; j < l[i]; j++)
				temp[j] = pairs[k++][1];
			noEmpty.add(i, temp);
		}
		
		LinkedList<int[]>[] lengths;
        lengths = new LinkedList[lmax+1];
        for (i = 0; i <= lmax; i++) {
            lengths[i] = new LinkedList<int[]>();
        }
        
        
		for(i = 0; i < n; i++)
			if (A.get(i).length == lens[i])
				lengths[lens[i]].addLast(A.get(i));
		
		
		
		 Deque<int[]> QUEUE = new LinkedList<int[]>();
	     LinkedList<int[]>[] Q;
	     Q = new LinkedList[m];

	     for (i = 0; i < m; i++) 
             Q[i] = new LinkedList<int[]>();
         
             
	     for (j = lmax; j != 0; j--)
	     {
	    	 for (i = lengths[j].size(); i > 0; i--)
	    		 QUEUE.addFirst(lengths[j].get(i-1));
	        
	         while (!QUEUE.isEmpty()) {
	                int[] Ai = QUEUE.getFirst();
	                QUEUE.removeFirst();
	                Q[Ai[j-1]].addLast(Ai);
	            }
	         
	         for(i = 0; i < noEmpty.get(j-1).length; i++)	 
	        	 for (k = 0; k < m; k++)
	        	 	if(noEmpty.get(j-1)[i] == k)
	        	 		while (!Q[k].isEmpty())
	        	 			QUEUE.addLast(Q[k].removeFirst()); 
	     }    
	      
	 
	    for(i = 0; !QUEUE.isEmpty(); i++)	 
	    	A.set(i, QUEUE.removeFirst());	    	
		
	}
	
	
	////////////////////////////////////////////
	
	private static void sortFixSize(int[][] pairs, int n, int k, int m) {
        Deque<int[]> QUEUE = new LinkedList<int[]>();
        LinkedList<int[]>[] Q;
        Q = new LinkedList[m];
        for (int i = 0; i < n; i++) {
            QUEUE.push(pairs[i]);
        }
       
        for (int j = k-1; j >= 0 ; j--) {
        	
            for (int l = 0; l < m; l++) {
                Q[l] = new LinkedList<int[]>();
            }
            
            while (!QUEUE.isEmpty()) {
                int[] Ai = QUEUE.getFirst();
                QUEUE.removeFirst();
                Q[Ai[j]].addLast(Ai);

            }
            for (int l = 0; l < m; l++) {
                QUEUE.addAll(Q[l]);
            }
        }
        for (int i = 0; i < pairs.length; i++) {
            pairs[i] = QUEUE.pop();
        }
    	
    }
	
}
