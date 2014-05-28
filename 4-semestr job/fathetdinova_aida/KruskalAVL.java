package semestrovka;
import java.util.*;

 
public class KruskalAVL {
	
    private int weight;  
    private Queue<Edge> mst = new LinkedList<Edge>();

   
    public KruskalAVL(EdgeWeightedGraph G) {
    	
    	 AvlTree x = new AvlTree();  // множество вершин
    	 MinPQ<Edge> pq = new MinPQ<Edge>();
    	 
        for (Edge e : G.edges()) {
        	x.insert(e.v);
        	x.insert(e.w);
            pq.insert(e);
        }
        	x.show(x.root);
       
        while (!pq.isEmpty() && mst.size() < G.V() - 1) {
            Edge e = pq.delMin();
            int v = e.either();
            int w = e.other(v);
          if (x.isconnected(v, w)) {
        	  System.out.println(x.isconnected(v, w));
        	   x.union(v, w);
                mst.add(e);   
                weight += e.weight();
            }
        }
    }
        public Iterable<Edge> edges() {
            return mst;
        }

        public int weight() {
            return weight;
        
 
    
}}