package semestrovka;

import java.util.LinkedList;
import java.util.Queue;

public class Kruskal {
    private double weight;  
    private Queue<Edge> mst = new LinkedList<Edge>();

  
    public Kruskal(EdgeWeightedGraph G) {
       
        MinPQ<Edge> pq = new MinPQ<Edge>();
        for (Edge e : G.edges()) {
            pq.insert(e);
        }

     
        UF uf = new UF(G.V());
        while (!pq.isEmpty() && mst.size() < G.V() - 1) {
            Edge e = pq.delMin();
            int v = e.either();
            int w = e.other(v);
            if (!uf.connected(v, w)) { 
                uf.union(v, w); 
                mst.add(e); 
                weight += e.weight();
            }
        }

    }

    public Iterable<Edge> edges() {
        return mst;
    }

  
    public double weight() {
        return weight;
    }
    
   

}